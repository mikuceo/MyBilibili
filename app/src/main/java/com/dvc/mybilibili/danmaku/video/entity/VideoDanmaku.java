package com.dvc.mybilibili.danmaku.video.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class VideoDanmaku {
    @JSONField(name = "rec_flag")
	public int rec_flag = 3;
    @JSONField(name = "rec_text")
    public String rec_text = "开启后，全站视频将按等级等优化弹幕";
    @JSONField(name = "rec_switch")
    public int rec_switch = 1;
    @JSONField(name = "dmflags")
    public List<Danmu> dmlist;
    @Nullable
    public long oid;
    private int pe;

    public Danmu getDanmu(long dmid) {
        for (Iterator<Danmu> it = dmlist.iterator(); it.hasNext(); ) {
            Danmu danmu = it.next();
            if(danmu.dmid == dmid) return danmu;
        }
        return null;
    }

    public static VideoDanmaku create(String jsonstr, InputStream xmlis) throws ParserConfigurationException, IOException, SAXException {
        VideoDanmaku danmaku = JSON.parseObject(jsonstr, VideoDanmaku.class);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlis);
        xmlis.close();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        //遍历node list
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeName().contains("#text")) continue;
            if(node.getNodeName().equals("oid")) {
                danmaku.oid = Long.valueOf(node.getTextContent());
                continue;
            }
            if(node.getNodeName().equals("pe")) {
                danmaku.pe = Integer.valueOf(node.getTextContent());
                continue;
            }
            if(node.getNodeName().equals("d")) {
                String[] values = node.getAttributes().getNamedItem("p").getNodeValue().split(",");
                long dmid = Long.valueOf(values[0]);
                danmaku.getDanmu(dmid).unk1 = Integer.valueOf(values[1]);
                danmaku.getDanmu(dmid).unk2 = Integer.valueOf(values[2]);
                danmaku.getDanmu(dmid).unk3 = Integer.valueOf(values[3]);
                danmaku.getDanmu(dmid).unk4 = Integer.valueOf(values[4]);
                danmaku.getDanmu(dmid).unk5 = Integer.valueOf(values[5]);
                danmaku.getDanmu(dmid).time = Integer.valueOf(values[6]);
                danmaku.getDanmu(dmid).unk6 = Integer.valueOf(values[7]);
                danmaku.getDanmu(dmid).color = Long.decode("0x"+values[8]);
                danmaku.getDanmu(dmid).msg = node.getTextContent();
                continue;
            }
        }
        return danmaku;
    }

    //<i>
    // <oid>21642717</oid>
    // <ps>0</ps>
    // <pe>242000</pe>
    // <pc>1</pc>
    // <pn>1</pn>
    // <state>0</state>
    // <real_name>0</real_name>
    // <d p="3677109604,0,49414,1,25,16777215,1502364195,0,6f407c54">第一</d>
    // </i>
    //"3677109604,0,49414,1,25,16777215,1502364195,0,6f407c54"
    public class Danmu {
        @JSONField(name = "flag")
        public int flag;
        @JSONField(name = "dmid")
        public long dmid;
        public int unk1;//0
        public int unk2;//49414
        public int unk3;//1
        public int unk4;//25
        public int unk5;//16777215
        public long time;//1502364195
        public int unk6;//0
        public long color;//6f407c54
        public String msg;
    }
}
