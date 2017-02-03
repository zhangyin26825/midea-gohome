package com.weijuju.iag.midea.gohome.stat;/**
 * Created by zhangyin on 2016/12/29.
 */

import com.weijuju.iag.common.service.RedisLockService;
import com.weijuju.iag.mapper.StatObjectMapper;
import com.weijuju.iag.midea.gohome.dataobject.City;
import com.weijuju.iag.midea.gohome.dataobject.CityExample;
import com.weijuju.iag.midea.gohome.dataobject.StatObject;
import com.weijuju.iag.midea.gohome.filter.SimpleCORSFilter;
import com.weijuju.iag.midea.gohome.util.WeatherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author zhangyin
 * @create 2016-12-29
 */
@Component
public class Stat {

    private static  String  prefix="midea:gohome:stat:";

    private static  String  getdim(){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return prefix+df.format(new Date())+":"+ SimpleCORSFilter.qudao.get();
    }
    private static String getToday(){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    @Autowired
    BaseRedisOperation operation;

    @Autowired
    RedisLockService redisLockService;

    @Autowired
    StatObjectMapper statObjectMapper;

    private static String pv="pv";
    private static String uv="uv";

    private static String dimension=prefix+":dimension";

    public void addPVUV(String userid){
        String dim=getdim();
        operation.incrementLong(dim+pv);
        operation.addToSet(dim+uv,userid);
        operation.addToSet(dimension+getToday(),dim);
    }

    public Long getPV(String dim){
        return operation.getLong(dim + pv);
    }

    public Long getUV(String dim){
        return operation.getSizeOfSet(dim + uv);
    }
    public void clearPVUV(String dim){
        operation.removeLong(dim+pv);
        operation.removeSet(dim + uv);
    }



    private static String ImmediatelyGeneratepv="ImmediatelyGeneratepv";
    private static String ImmediatelyGenerateuv="ImmediatelyGenerateuv";

    public void addImmediatelyGenerate(String userid){
        operation.incrementLong(getdim()+ImmediatelyGeneratepv);
        operation.addToSet(getdim()+ImmediatelyGenerateuv,userid);
    }

    public Long getImmediatelyGeneratePV(String dim){
        return operation.getLong(dim + ImmediatelyGeneratepv);
    }

    public Long getImmediatelyGenerateUV(String dim){
        return operation.getSizeOfSet(dim + ImmediatelyGenerateuv);
    }
    public void clearImmediatelyGenerate(String dim){
        operation.removeLong(dim+ImmediatelyGeneratepv);
        operation.removeSet(dim + ImmediatelyGenerateuv);
    }




    private static String helppv="helppv";
    private static String helpuv="helpuv";

    public void addHelp(String userid){
        operation.incrementLong(getdim()+helppv);
        operation.addToSet(getdim()+helpuv,userid);
    }

    public Long getHelpPV(String dim){
        return operation.getLong(dim + helppv);
    }

    public Long getHelpUV(String dim){
        return operation.getSizeOfSet(dim + helpuv);
    }
    public void clearHelp(String dim){
        operation.removeLong(dim+helppv);
        operation.removeSet(dim + helpuv);
    }


    private static String OpenPackagepv="OpenPackagepv";
    private static String OpenPackageuv="OpenPackageuv";

    public void addOpenPackage(String userid){
        operation.incrementLong(getdim()+OpenPackagepv);
        operation.addToSet(getdim()+OpenPackageuv,userid);
    }

    public Long getOpenPackagePV(String dim){
        return operation.getLong(dim + OpenPackagepv);
    }

    public Long getOpenPackageUV(String dim){
        return operation.getSizeOfSet(dim + OpenPackageuv);
    }
    public void clearOpenPackage(String dim){
        operation.removeLong(dim+OpenPackagepv);
        operation.removeSet(dim + OpenPackageuv);
    }


    private static String ActivitySharepv="ActivitySharepv";
    private static String ActivityShareuv="ActivityShareuv";

    public void addActivityShare(String userid){
        operation.incrementLong(getdim()+ActivitySharepv);
        operation.addToSet(getdim()+ActivityShareuv,userid);
    }

    public Long getActivitySharePV(String dim){
        return operation.getLong(dim + ActivitySharepv);
    }

    public Long getActivityShareUV(String dim){
        return operation.getSizeOfSet(dim + ActivityShareuv);
    }
    public void clearActivityShare(String dim){
        operation.removeLong(dim+ActivitySharepv);
        operation.removeSet(dim + ActivityShareuv);
    }

    private static String numberofwinners="NumberOfWinners";

    public void addNumberOfWinners(){
        operation.incrementLong(getdim()+numberofwinners);
    }
    public Long getNumberOfWinners(String dim){
        return operation.getLong(dim + numberofwinners);
    }
    public void clearNumberOfWinners(String dim){
        operation.removeLong(dim+numberofwinners);
    }


    private static String NewUser="NewUser";

    public void addNewUser(){
        operation.incrementLong(getdim()+NewUser);
    }
    public Long getNewUser(String dim){
        return operation.getLong(dim + NewUser);
    }
    public void clearNewUser(String dim){
        operation.removeLong(dim+NewUser);
    }






    public StatObject getStatObject(String dim){
        StatObject statObject=new StatObject();
        statObject.setPv(getPV(dim).intValue());
        statObject.setUv(getUV(dim).intValue());
        statObject.setActivitysharepv(getActivitySharePV(dim).intValue());
        statObject.setActivityshareuv(getActivityShareUV(dim).intValue());
        statObject.setHelppv(getHelpPV(dim).intValue());
        statObject.setHelpuv(getHelpUV(dim).intValue());
        statObject.setImmediatelygeneratepv(getImmediatelyGeneratePV(dim).intValue());
        statObject.setImmediatelygenerateuv(getImmediatelyGenerateUV(dim).intValue());
        statObject.setOpenpackagepv(getOpenPackagePV(dim).intValue());
        statObject.setOpenpackageuv(getOpenPackageUV(dim).intValue());
        statObject.setNumberofwinners(getNumberOfWinners(dim).intValue());
        statObject.setNewuser(getNewUser(dim).intValue());
        return statObject;
    }

    public void clear(String dim){
        clearActivityShare(dim);
        clearHelp(dim);
        clearImmediatelyGenerate(dim);
        clearOpenPackage(dim);
        clearNumberOfWinners(dim);
        clearPVUV(dim);
        clearNewUser(dim);
    }

    private static String redisLocks="mideagohome:stat";
    @Scheduled(cron = "0 59 23 * * ?")
    public void daystat(){
        boolean lock = redisLockService .tryLock(redisLocks);
        if(!lock){
            return;
        }
        try {
//            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//            String format = df.format(new Date());
//            String dim = getdim();
            String today = getToday();
            Set<String> dimensions = operation.getSet(dimension + today);
            Thread.sleep(61*1000);
            for (String dim : dimensions) {
                StatObject statObject = getStatObject(dim);
                statObject.setStatDate(today);
                int i = dim.lastIndexOf(":");
                statObject.setQudao(dim.substring(i,dim.length()));
                statObjectMapper.insert(statObject);
                clear(dim);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisLockService.unLock(redisLocks);
        }
    }

    public List<StatObject> getTodayStat(){
        String today = getToday();
        Set<String> dimensions = operation.getSet(dimension + today);
        List<StatObject> result=new ArrayList<>(dimensions.size());
        for (String dim : dimensions) {
            StatObject statObject = getStatObject(dim);
            statObject.setStatDate(today);
            int i = dim.lastIndexOf(":");
            statObject.setQudao(dim.substring(i,dim.length()));
            result.add(statObject);
        }
        return result;
    }





}
