package com.markerhub.listener;

import cn.hutool.core.date.DateTime;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.markerhub.entity.Quota;
import com.markerhub.entity.QuotaOptions;
import com.markerhub.service.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: DiCraft
 * @Date: 2022/11/4 20:50
 * @package: cn.cq.quota.listener
 * @Version: 1.0
 * @Decsription:
 */
public class QuotaReadingListener extends AnalysisEventListener<Map<Integer, String>> {

    private List<Map<Integer, String>> list = new ArrayList<>();

    @Autowired
    private QuotaService quotaService;


    public QuotaReadingListener(QuotaService quotaService) {
        this.quotaService = quotaService;
    }



    @Override
    public void invoke(Map<Integer,String> quotaData, AnalysisContext analysisContext) {
//        String data = JSON.toJSONString(quotaData, SerializerFeature.WriteNullStringAsEmpty);
//        System.out.println(data);
        list.add(quotaData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        //构造数据插入
        //最后一个指标数据库id
        int lastId = 0;

        int keyId = 0;

        //指标id
        Map<Integer, Integer> lastIdMap = new HashMap<>();

        List<QuotaOptions> listOp = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            Map<Integer,String> tmp =list.get(i);
            lastId = 0;

            //获取第一个keyNum
            int firstKey = getKeyNum(tmp);

            if (firstKey == 0) {

                lastIdMap.clear();

                //插入各大级指标
                int num = tmp.size() / 2;

                for (int j = 0; j < num ; j++) {

                    Quota q1 = new Quota();
                    q1.setQuotaName(tmp.get(2*j));
                    q1.setQuotaRight(tmp.get(2*j+1));
                    q1.setParentId(lastId);
                    q1.setCreatedTime(DateTime.now());
                    q1.setUpdatedTime(DateTime.now());
                    //插入得到数据库返回id
                    quotaService.insertQuota(q1);

                    lastId = q1.getId();
                    lastIdMap.put(j,lastId);
                }

                //插入选项
                QuotaOptions option = new QuotaOptions();
                option.setOptionsName(tmp.get(tmp.size() - 1));
                option.setQuotaId(lastId);
                listOp.add(option);

            } else {

                //单指标
                if (firstKey == tmp.size() - 1) {

                    //插入
                    QuotaOptions option = new QuotaOptions();
                    option.setOptionsName(tmp.get(tmp.size() - 1));
                    option.setQuotaId(lastIdMap.get(firstKey / 2 - 1));
                    listOp.add(option);

                } else {
                    int num = (tmp.size() - firstKey - 1) / 2;

                    for (int j =0;j < num;j++){


                        Quota q1 = new Quota();
                        q1.setQuotaName(tmp.get(firstKey+ 2*j));
                        q1.setQuotaRight(tmp.get(firstKey+ 2*j + 1));
                        q1.setParentId(lastIdMap.get((firstKey + 2*j) / 2 - 1));
                        q1.setCreatedTime(DateTime.now());
                        q1.setUpdatedTime(DateTime.now());
                        // 插入得到数据库返回id
                        quotaService.insertQuota(q1);
                        lastId = Math.toIntExact(q1.getId());
                        lastIdMap.put((firstKey + 2*j) / 2 , lastId);
                    }

                    //插入选项Quota
                    QuotaOptions option = new QuotaOptions();
                    option.setOptionsName(tmp.get(tmp.size() - 1));
                    option.setQuotaId(lastId);
                    listOp.add(option);
                }
            }
        }

        quotaService.insertOptions(listOp);

    }

    public int getKeyNum(Map<Integer,String> map) {
        for (Integer key : map.keySet()) {
            if (map.get(key) != null) {
                return key.intValue();
            }
        }
        return 0;
    }
    public int getInsertNum(int id) {
        return ++id;
    }
}

