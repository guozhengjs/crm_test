import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //验证失效时间
        String expireTime = "2019-10-10 10:10:10";
        //当前系统时间
        String currentTime = DateTimeUtil.getSysTime();
        int count = expireTime.compareTo(currentTime);
        System.out.println(count);
        System.out.println("================");
        Date date = new Date();
        System.out.println(date);
        System.out.println("================");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        System.out.println(str);
        System.out.println("========");

        String lockState = "0";
        if("0".equals(lockState)){
            System.out.println("账号已锁定");
        }
        System.out.println("=============");
        //浏览器端的ip地址
        String ip = "192.168.1.1";
        //允许访问的IP地址群
        String allowIps = "192.168.1.1,192.168.1.2";
        if(allowIps.contains(ip)){
            System.out.println("有效的ip地址");
        }else{
            System.out.println("ip地址受限，无法访问");
        }
        System.out.println("==============");

        String pwd = "123";
        pwd = MD5Util.getMD5(pwd);
        System.out.println(pwd);
    }
}
