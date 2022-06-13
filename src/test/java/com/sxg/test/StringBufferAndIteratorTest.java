package com.sxg.test;


import java.text.SimpleDateFormat;
import java.util.*;

public class StringBufferAndIteratorTest {

    public static void main(String[] args) {

        System.currentTimeMillis();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println(System.currentTimeMillis());
        System.out.println(date);
        String  op_code = "provBoss"+"_"+"12";
        System.out.println(op_code);

        String export_sql ="o.order_id,o.type_code,o.status,to_char(o.last_update,'YYYY-MM-DD hh24:mi:ss') last_update,oe.out_tid,oe.zb_inf_id,oe.spread_channel spreadchannel,o.deal_message,(CASE o.order_record_status WHEN 0 THEN '' ELSE o.order_record_status||'' END) AS order_record_status,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "ot.acc_nbr,ot.col2,ot.col4,ot.col7 luckyClass,ot.col3,ot.col6,ot.imei,o.order_amount,o.goods_id,o.shipping_type,o.remark,oe.goods_name,ob.cust_name uname,ob.contact_phone cphone,ob.contact_name cname,(case when o.type_code='30012' then sf_get_public_ext('xykd_type', ob.broadband_type) else ob.broadband_type end ) broadband_type,(CASE o.ship_group_id WHEN '0' THEN '未验签' WHEN '1' THEN '已验签' WHEN '2' THEN '无需验签' END) AS ship_group_id,isdate(pay_group_id) pay_group_id,\n" +
                "o.create_time,oe.order_from,oe.col3 tccol3,oe.order_points,ob.ic_no,ob.ic_type,ob.city_id,ob.install_addr,ob.district,ob.faileCause,o.pay_time,eog.grab_order_rule,eog.grab_order_range,eog.grab_staff,to_char(eog.grab_time,'YYYY-MM-DD hh24:mi:ss') as grab_time,operator_id,operator_siteid,\n" +
                "(select e.agency_name from es_order_agency e where agency_code = sf_get_expand_value(o.order_id, 'agency_code') ) agency_name, to_char(ob.appointment_time,'yyyy-mm-dd hh24:mi:ss') appointment_time,\n" +
                "o.service_type,oe.market_sale_id,oe.market_sale_name,oe.last_deal_time,decode(oe.abnormal_status,'00A','否','00D','是','否') is_exception,sf_get_expand_value(o.order_id,'writeCardTime') xk_time,to_char((case when o.status = '88' then o.last_update end),'YYYY-MM-DD hh24:mi:ss') jh_time,(case  when eog.status='0' then '待抢单' when eog.status='1' then '已抢单' when eog.status='2' then '已抢单' when eog.status='3' then '已抢单' when eog.status is null  then '不抢单' when eog.status>='4' then '已过期' end) as is_grab_order,\n" +
                "(CASE oe.is_over_time WHEN 0 THEN'否'ELSE '是' END) AS is_over_time,oe.site_id,(case when o.type_code='30012' then sf_get_public_ext('xyyw_type', oe.tid_category) else oe.tid_category end) tid_category,oe.col6 schdate,oe.col7,oe.site_name,sf_get_expand_value(o.order_id,'referrerName') referrerName,sf_get_expand_value(o.order_id,'oldDiffNet') oldDiffNet,(CASE oe.invoice_flag WHEN '1' THEN'是'ELSE '否' END) as invoice_flag,ed.ship_mobile, \n" +
                " ed.ship_name,ed.ship_email,(case oe.order_from when '115' then ed.province||ed.city||ed.region||ed.ship_addr when '116' then ed.province||ed.city||ed.region||ed.ship_addr when '109' then ed.province||ed.city||ed.region||ed.ship_addr when '121' then ed.province||ed.city||ed.region||ed.ship_addr when '130' then ed.province||ed.city||ed.region||ed.ship_addr when '131' then ed.province||ed.city||ed.region||ed.ship_addr else ed.ship_addr end) as cust_addr, \n" +
                "(case oe.order_from when '102' then ed.house_id when '103' then ed.house_id when '120' then ed.house_id when '202' then ed.house_id when '203' then ed.house_id when '220' then ed.house_id else ed.province end) jssf,ed.city jsds,ed.region jsqx,(case oe.order_from when '102' then ed.province when '103' then ed.province when '120' then ed.province when '202' then ed.province when '203' then ed.province when '220' then ed.province else '' end) jsjd,\n" +
                "sf_get_expand_value(o.order_id,'isFrozenFee') isFrozenFee,sf_get_expand_value(o.order_id,'buziActType') buziActType,sf_get_expand_value(o.order_id,'saleIdLv2') saleIdLv2,sf_get_expand_value(o.order_id,'joinCoreFaNum') joinCoreFaNum,sf_get_expand_value(o.order_id,'joinFaNetNum') joinFaNetNum,sf_get_expand_value(o.order_id,'shareFunNum') shareFunNum,(case when o.shipping_type='OAO' then ed.col2 else ed.logi_id end) delivery_exp_no,ed.shipping_company delivery_express,\n" +
                " (select operation_result from ( select e.order_id,e.operation_result from ES_ORDER_AUDITE e where operation_type='cancelAuditOrderTime' order by operation_time desc) t where t.order_id=o.order_id and rownum = 1) operation_result,o.bank_id fxly1, o.goods fxly2,\n" +
                " sf_get_public_ext('type_code', o.type_code) type_code_c, sf_get_public_ext('order_status', o.status) order_status_c, sf_get_public_ext('shipping_type', o.shipping_type) shipping_type_c, sf_get_public_ext('yyd_plan_type', ob.broadband_type) broadband_type_name,\n" +
                "sf_get_public_ext('order_from', oe.order_from) order_from_c, sf_get_public_ext('order_city_name', ob.city_id) city_name, sf_get_public_ext('pay_status', o.pay_status) pay_status, sf_get_public_ext((case when o.type_code = '30006' then '4g_self_bundle_status' else 'order_confirm_status_30000' end), o.confirm_status) confirm_status,\n" +
                "decode(oe.col2,'b01','普通usim','b02','nfc usim卡','b03','3.0usim',oe.col2) numcard_type,\n" +
                " (select cust_manager_name from (SELECT A.CUST_MANAGER_NAME, A.order_id FROM ES_ORDER_SYN_LOGS A ORDER BY A.CREATE_TIME DESC) t where t.order_id = o.order_id and rownum = 1) cust_manager_name,\n" +
                "(select cust_manager_phone from (SELECT A.order_id, A.CUST_MANAGER_PHONE FROM ES_ORDER_SYN_LOGS A ORDER BY A.CREATE_TIME DESC) t where t.order_id = o.order_id and rownum = 1) cust_manager_phone,o.order_adscription_id,ot.spec_id login_msisdn,sf_get_expand_value(o.order_id,'market_id') market_id,sf_get_expand_value(o.order_id,'market_levelid') market_levelid,sf_get_expand_value(o.order_id,'orderGrabFinishDate') orderGrabFinishDate ,sf_get_expand_value(o.order_id,'market_busi_pack_id') market_busi_pack_id,sf_get_expand_value(o.order_id,'market_busi_id') market_busi_id \n" +
                "from \"+order_table +\" o,\"+order_ext_table+\" oe,\"+es_order_busi+\" ob,\"+es_order_items_table+\" ot \" + \",es_delivery ed,es_order_graborder eog\n" +
                " where o.order_id=oe.order_id and o.order_id=ob.order_id(+) and o.order_id = eog.order_id(+)\n" +
                " and o.order_id=ot.order_id(+) and o.order_id=ed.order_id(+) and o.source_from='JS'";


        StringBuilder stringBuilder =new StringBuilder();
        String[] sqls = new String[10];
        for(int i = 0 ; i < 10 ; i ++){
            if (export_sql.length() > 3000) {
                int a =export_sql.length();
                System.out.println(a);
                sqls[i] = export_sql.substring(0 ,3000);
                stringBuilder.append(sqls[i]);
                export_sql = export_sql.substring(3000,export_sql.length());
                if (sqls[i].endsWith("'") && export_sql.length() > 0 && export_sql.subSequence(0, 1).equals("'")) {
                    sqls[i] = sqls[i] + "'";
                    export_sql = export_sql.substring(1,export_sql.length());
                }
            }else{
                sqls[i] = export_sql;
                export_sql = "";
                stringBuilder.append(sqls[i]);
            }
        }


        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        Map order_info_dt = new HashMap();
        order_info_dt.put("Status","123");
        order_info_dt.put("remark","456");
        order_info_dt.put("amount","789");
        order_info_dt.put("qwe","aaa");
        order_info_dt.put("erw","bbb");
        String Status =(String) order_info_dt.get("Status");
        String remark =(String) order_info_dt.get("remark");
        String amount =(String) order_info_dt.get("amount");
        // map用迭代器删除key
        Iterator<String> iterator = order_info_dt.keySet().iterator();
        while (iterator.hasNext()){// 循环取键值进行判断
            String key = iterator.next();// 键
            if("Status".equals(key)||"remark".equals(key)||"amount".equals(key)){
                iterator.remove();
            }
        }
        order_info_dt.put("status", Status);
        order_info_dt.put("Remark", remark);
        order_info_dt.put("Amount", amount);



    }
}
