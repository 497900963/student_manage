package cn.wang.manage.util;



import cn.wang.manage.config.ResultJson;

import java.util.Map;

/**
 * @Program: k9_tms
 * @Description:
 * @Author: wei.wang
 * @Date: 2021-04-06 21:16
 **/
public class ParamUtil {

    /**
     * @Description: 验证参数
     * @Param: [parMap, paramNames]
     * @return: cn.kj0901.tms.base.config.ResultJson
     * @Author: Wei.Wang
     * @Date: 2021/4/6
     */
    public static ResultJson checkParam(Map<String, Object> parMap, String[] paramNames) {

        if (parMap == null) {
            return ResultJson.err(201, "参数不能为空");
        }
        for (int i = 0; i < paramNames.length; i++) {
            String paramName = paramNames[i];
            Object para = parMap.get(paramName);
            if (para == null || para.equals("")) {
                return ResultJson.err(201, paramName+"不能为空");
            }
        }
        return ResultJson.ok();
    }

    /**
     * @Description: 验证并插入page信息
     * @Param: [parMap, pageNum, pageSize]
     * @return: void
     * @Author: Wei.Wang
     * @Date: 2021/4/7
     */
    public static void putPageInfo(Map<String, Object> parMap, Integer pageNum, Integer pageSize) {
        if (parMap.get("pageNum") != null && "".equals(parMap.get("pageNum"))) {
            pageNum = Integer.valueOf(parMap.get("pageNum").toString());
        }
        if (parMap.get("pageSize") != null && "".equals(parMap.get("pageSize"))) {
            pageSize = Integer.valueOf(parMap.get("pageSize").toString());
        }
    }
}
