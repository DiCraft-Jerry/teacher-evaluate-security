package com.markerhub.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.*;
import com.markerhub.mapper.CourseResoureMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/work/courseresoure")
public class CourseResoureController extends BaseController{

    /**
     * 把地址引进
     */
    @Value("${files.upload.path}")
    private String fileUploadPath;


    @Resource
    private CourseResoureMapper courseResoureMapper;


    /**
     * 文件上传接口
     *
     * @param file 前端传递过来的文件
     * @return
     * @throws IOException
     */
    @PreAuthorize("hasAuthority('work:courseresoure:save')")
    @PostMapping("/save")
    public String upload(@Validated @RequestParam MultipartFile file) throws Exception {

        String originalFilename = file.getOriginalFilename();
        //获取文件的类型
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        // 定义一个文件唯一的标识码
        String fileUUID = IdUtil.fastSimpleUUID() + StrUtil.DOT + type;

        File uploadFile = new File(fileUploadPath + fileUUID);

        // 判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();

        if(!parentFile.exists()) {
            parentFile.mkdirs();

        }

        //获取文件url
        String url;
        // 获取文件的md5
        String md5 = SecureUtil.md5(file.getInputStream());

        // 从数据库查询是否存在相同的记录
        CourseResoure dbFiles = getFileByMd5(md5);

        if (dbFiles != null) {
            url = dbFiles.getUrl();

        } else {
            // 上传文件到磁盘
            file.transferTo(uploadFile);
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            url = "http://loaclhost:8081/work/courseresoure/" + fileUUID;
        }



        //存进数据库
        CourseResoure courseResoure=new CourseResoure();
        courseResoure.setName(originalFilename);
        courseResoure.setType(type);
        courseResoure.setUrl(url);
        courseResoure.setSize(size/1024);
        courseResoure.setMd5(md5);
        courseResoureMapper.insert(courseResoure);
       // courseResoureService.save(courseResoure);

        // 从redis取出数据，操作完，再设置（不用查询数据库）
//        String json = stringRedisTemplate.opsForValue().get(Constants.FILES_KEY);
//        List<Files> files1 = JSONUtil.toBean(json, new TypeReference<List<Files>>() {
//        }, true);
//        files1.add(saveFile);
//        setCache(Constants.FILES_KEY, JSONUtil.toJsonStr(files1));


        // 从数据库查出数据
//        List<Files> files = fileMapper.selectList(null);
//        // 设置最新的缓存
//        setCache(Constants.FILES_KEY, JSONUtil.toJsonStr(files));

        // 最简单的方式：直接清空缓存
//        flushRedis(Constants.FILES_KEY);

        return url;
    }


    /**
     * 文件下载接口   http://localhost:8081/work/courseresoure/{fileUUID}
     * @param fileUUID
     * @param response
     * @throws IOException
     */
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
        // 根据文件的唯一标识码获取文件
        File uploadFile = new File(fileUploadPath + fileUUID);
        // 设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");

        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }


    /**
     * 通过文件的md5查询文件
     * @param md5
     * @return
     */
    private CourseResoure getFileByMd5(String md5) {
        // 查询文件的md5是否存在
        QueryWrapper<CourseResoure> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<CourseResoure> courseResoures = courseResoureMapper.selectList(queryWrapper);
        return courseResoures.size() == 0 ? null : courseResoures.get(0);
    }

    @PreAuthorize("hasAuthority('work:courseresoure:update')")
    @PostMapping("/update")
    public Result update(@Validated @RequestBody CourseResoure courseResoure) {
        System.out.println(courseResoure);
        courseResoureService.updateById(courseResoure);

        return Result.succ(courseResoure);
    }

    @GetMapping("/detail/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.succ(courseResoureMapper.selectById(id));
    }

    @Transactional
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('work:courseresoure:delete')")
    public Result delete(@RequestBody Long[] ids) {
        courseResoureService.removeByIds(Arrays.asList(ids));

        return Result.succ("");
    }


    /**
     * 分页查询接口
     * @param name
     * @return
     */
    @PreAuthorize("hasAuthority('work:courseresoure:list')")
    @GetMapping("/list")
    public Result findPage(@RequestParam(defaultValue = "") String name) {

        QueryWrapper<CourseResoure> queryWrapper = new QueryWrapper<>();
        // 查询未删除的记录
        queryWrapper.eq("is_delete", false);
        queryWrapper.orderByDesc("id");
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }

        Page<CourseResoure> pageData = courseResoureService.page(getPage(), new QueryWrapper<CourseResoure>()
                .like(StrUtil.isNotBlank(name), "name", name));

        return Result.succ(pageData);
    }

    @PreAuthorize("hasAuthority('work:courseresoure:list')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Long id) {

        CourseResoure courseResoure = courseResoureService.getById(id);

        List<CourseInfo> courseInfo = courseInfoService.listCourseByResoureId(id);

        courseResoure.setCourseInfoList(courseInfo);

        return Result.succ(courseResoure);
    }

    @Transactional
    @PostMapping("/course/{resoureId}")
    @PreAuthorize("hasAuthority('work:courseresoure:course')")
    public Result rolePerm(@PathVariable("resoureId") Long resoureId, @RequestBody Long[] roleIds) {

        System.out.println("资料id"+resoureId);
        List<Catalogue> catalogues = new ArrayList<>();


        Arrays.stream(roleIds).forEach(r -> {

            Catalogue catalogue = new Catalogue();
            catalogue.setCourseId(r);
            catalogue.setResoureId(resoureId);

            catalogues.add(catalogue);


        });


        catalogueService.remove(new QueryWrapper<Catalogue>().eq("resoure_id", resoureId));
        catalogueService.saveBatch(catalogues);


        // 删除缓存
        CourseResoure courseResoure = courseResoureService.getById(resoureId);
        courseResoureService.clearUserAuthorityInfo(courseResoure.getName());


        return Result.succ("");
    }



}
