package com.it1224.demos.psandbase.official.im.util;

import android.content.Context;

import com.it1224.demos.psandbase.official.global.Constant;
import com.it1224.demos.psandbase.official.im.service.MessageIQProvider;
import com.it1224.demos.psandbase.official.im.service.MessageListener;
import com.it1224.demos.psandbase.official.im.service.NotificationIQ;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Registration;
import org.jivesoftware.smack.provider.ProviderManager;


/**
 * © 2012 amsoft.cn
 * 名称：IMUtil.java
 * 描述：TODO
 *
 * @author Administrator
 * @version v1.0
 * @date 2015年7月25日 上午10:01:00
 */
public class IMUtil {

    public static void login(Context context, String userName, String password) {
        try {
            ConnectionConfiguration connConfig = new ConnectionConfiguration(Constant.xmppHost, Constant.xmppPort);
            connConfig.setReconnectionAllowed(true);
            connConfig.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
            connConfig.setSASLAuthenticationEnabled(true);
            connConfig.setTruststorePath("/system/etc/security/cacerts.bks");
            connConfig.setTruststorePassword("changeit");
            connConfig.setTruststoreType("bks");
            XMPPConnection connection = new XMPPConnection(connConfig);
            connection.connect();

            // 设置消息接收器
            ProviderManager.getInstance().addIQProvider("notification", "androidpn:iq:notification", new MessageIQProvider());
            PacketFilter packetFilter = new PacketTypeFilter(NotificationIQ.class);
            connection.addPacketListener(new MessageListener(context), packetFilter);


            connection.login(userName, password, "AndroidPNClient");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(String userName, String password) {
        try {
            ConnectionConfiguration connConfig = new ConnectionConfiguration(Constant.xmppHost, Constant.xmppPort);
            connConfig.setReconnectionAllowed(true);
            connConfig.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
            connConfig.setSASLAuthenticationEnabled(true);
            connConfig.setTruststorePath("/system/etc/security/cacerts.bks");
            connConfig.setTruststorePassword("changeit");
            connConfig.setTruststoreType("bks");
            XMPPConnection connection = new XMPPConnection(connConfig);
            connection.connect();

            // 注册、传递参数过程
            Registration registration = new Registration();
            registration.setType(IQ.Type.SET);
            registration.addAttribute("username", userName);
            registration.addAttribute("password", password);
            connection.sendPacket(registration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quit(String userName) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
