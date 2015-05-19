package com.run.sango.model;

import java.awt.*;

public class TempModel {
	
	public TempModel() {
		
	}

	public void asd(Graphics g) {
        // city = new City(Name)
        // setNeighbours(��, ��, ��, ��)
        // setNeighbours(��, ��, ��, ��, ����, ����, ����, ����)
        
        // ����
//        yunnan.setMapCoordinate(64, 555);
//        yunnan.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_JIANGZHOU, CITY_EMPTY, CITY_EMPTY);
//        // yunnan.setNewNeighbours(Neighbour.EMPTY, Neighbour.EMPTY, Neighbour.EMPTY, Neighbour.EMPTY, Neighbour.EMPTY, Neighbour.JIANGZHOU, Neighbour.EMPTY, Neighbour.EMPTY);
//        jiangzhou.setMapCoordinate(166, 450);
//        jiangzhou.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_CHENGDU, CITY_YONGAN, CITY_ZITONG, CITY_EMPTY, CITY_YUNNAN, CITY_EMPTY);
//        chengdu.setMapCoordinate(41, 459);
//        chengdu.setNeighbours(CITY_ZITONG, CITY_EMPTY, CITY_EMPTY, CITY_JIANGZHOU);
//        yongan.setMapCoordinate(242, 449);
//        yongan.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_JIANGZHOU, CITY_JIANGLING, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_WULING);
//        zitong.setMapCoordinate(47, 402);
//        zitong.setNeighbours(CITY_HANZHONG, CITY_CHENGDU, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_JIANGZHOU);
//        
//        // ��ԭ
//        xuchang.setMapCoordinate(429, 355);
//        xuchang.setNeighbours(CITY_PUYANG, CITY_EMPTY, CITY_WAN, CITY_EMPTY, CITY_LUOYANG, CITY_EMPTY, CITY_EMPTY, CITY_RUNAN);
//        wan.setMapCoordinate(362, 362);
//        wan.setNeighbours(CITY_LUOYANG, CITY_EMPTY, CITY_EMPTY, CITY_XUCHANG, CITY_CHANGAN, CITY_EMPTY, CITY_EMPTY, CITY_XINYE);
//        luoyang.setMapCoordinate(345, 321);
//        luoyang.setNeighbours(CITY_JINYANG, CITY_WAN, CITY_CHANGAN, CITY_CHENLIU, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_XUCHANG);
//        chenliu.setMapCoordinate(456, 316);
//        chenliu.setNeighbours(CITY_YE, CITY_XUCHANG, CITY_LUOYANG, CITY_XIAOPEI, CITY_EMPTY, CITY_PUYANG, CITY_EMPTY, CITY_EMPTY);
//        puyang.setMapCoordinate(511, 286);
//        puyang.setNeighbours(CITY_EMPTY, CITY_XIAOPEI, CITY_CHENLIU, CITY_EMPTY, CITY_YE, CITY_BEIHAI, CITY_EMPTY, CITY_EMPTY);
//        xiaopei.setMapCoordinate(556, 327);
//        xiaopei.setNeighbours(CITY_PUYANG, CITY_SHOUCHUN, CITY_EMPTY, CITY_XIAPI, CITY_CHENLIU, CITY_EMPTY, CITY_RUNAN, CITY_EMPTY);
//        xiapi.setMapCoordinate(607, 329);
//        xiapi.setNeighbours(CITY_BEIHAI, CITY_EMPTY, CITY_XIAOPEI, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_SHOUCHUN, CITY_EMPTY);
//        runan.setMapCoordinate(488, 388);
//        runan.setNeighbours(CITY_XUCHANG, CITY_EMPTY, CITY_EMPTY, CITY_SHOUCHUN, CITY_EMPTY, CITY_XIAOPEI, CITY_XINYE, CITY_EMPTY);
//        shouchun.setMapCoordinate(551, 397);
//        shouchun.setNeighbours(CITY_XIAOPEI, CITY_EMPTY, CITY_RUNAN, CITY_EMPTY, CITY_EMPTY, CITY_XIAPI, CITY_LUJIANG, CITY_JIANYE);
//        
//        // ����
//        xiliang.setMapCoordinate(47, 254);
//        xiliang.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_TIANSHUI);
//        tianshui.setMapCoordinate(102, 316);
//        tianshui.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_CHANGAN, CITY_XILIANG, CITY_EMPTY, CITY_EMPTY, CITY_HANZHONG);
//        changan.setMapCoordinate(236, 333);
//        changan.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_TIANSHUI, CITY_LUOYANG, CITY_EMPTY, CITY_EMPTY, CITY_HANZHONG, CITY_WAN);
//        hanzhong.setMapCoordinate(96, 364);
//        hanzhong.setNeighbours(CITY_EMPTY, CITY_ZITONG, CITY_EMPTY, CITY_SHANGYONG, CITY_TIANSHUI, CITY_CHANGAN, CITY_EMPTY, CITY_EMPTY);
//        
//        // ����
//        xinye.setMapCoordinate(397, 395);
//        xinye.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_WAN, CITY_RUNAN, CITY_XIANGYANG, CITY_JIANGXIA);
//        jiangxia.setMapCoordinate(426, 434);
//        jiangxia.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_XIANGYANG, CITY_LUJIANG, CITY_XINYE, CITY_EMPTY, CITY_JIANGLING, CITY_CHAISANG);
//        shangyong.setMapCoordinate(262, 382);
//        shangyong.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_HANZHONG, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_XIANGYANG);
//        jiangling.setMapCoordinate(331, 443);
//        jiangling.setNeighbours(CITY_XIANGYANG, CITY_EMPTY, CITY_YONGAN, CITY_CHAISANG, CITY_EMPTY, CITY_JIANGXIA, CITY_WULING, CITY_CHANGSHA);
//        wuling.setMapCoordinate(257, 527);
//        wuling.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_CHANGSHA, CITY_YONGAN, CITY_JIANGLING, CITY_EMPTY, CITY_LINGLING);
//        lingling.setMapCoordinate(336, 563);
//        lingling.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_WULING, CITY_GUIYANG);
//        guiyang.setMapCoordinate(414, 568);
//        guiyang.setNeighbours(CITY_CHANGSHA, CITY_EMPTY, CITY_LINGLING, CITY_EMPTY);
//        changsha.setMapCoordinate(394, 510);
//        changsha.setNeighbours(CITY_EMPTY, CITY_GUIYANG, CITY_WULING, CITY_CHAISANG, CITY_JIANGLING, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY);
//        xiangyang.setMapCoordinate(335, 405);
//        xiangyang.setNeighbours(CITY_EMPTY, CITY_JIANGLING, CITY_EMPTY, CITY_JIANGXIA, CITY_SHANGYONG, CITY_XINYE, CITY_EMPTY, CITY_EMPTY);
//        
//        // ��Խ
//        chaisang.setMapCoordinate(494, 501);
//        chaisang.setNeighbours(CITY_LUJIANG, CITY_EMPTY, CITY_JIANGLING, CITY_KUAIJI, CITY_JIANGXIA, CITY_JIANYE, CITY_CHANGSHA, CITY_EMPTY);
//        lujiang.setMapCoordinate(507, 437);
//        lujiang.setNeighbours(CITY_EMPTY, CITY_CHAISANG, CITY_JIANGXIA, CITY_JIANYE, CITY_EMPTY, CITY_SHOUCHUN, CITY_EMPTY, CITY_EMPTY);
//        jianye.setMapCoordinate(608, 433);
//        jianye.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_LUJIANG, CITY_WU, CITY_SHOUCHUN, CITY_EMPTY, CITY_CHAISANG, CITY_EMPTY);
//        wu.setMapCoordinate(676, 400);
//        wu.setNeighbours(CITY_EMPTY, CITY_KUAIJI, CITY_JIANYE, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY);
//        kuaiji.setMapCoordinate(650, 503);
//        kuaiji.setNeighbours(CITY_WU, CITY_EMPTY, CITY_CHAISANG, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY);
//        
//        // ����
//        xiangping.setMapCoordinate(758, 87);
//        xiangping.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_BEIPING, CITY_EMPTY);
//        beiping.setMapCoordinate(552, 152);
//        beiping.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_JI, CITY_EMPTY, CITY_EMPTY, CITY_XIANGPING, CITY_NANPI, CITY_EMPTY);
//        ji.setMapCoordinate(444, 152);
//        ji.setNeighbours(CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_BEIPING, CITY_EMPTY, CITY_EMPTY, CITY_JINYANG, CITY_NANPI);
//        jinyang.setMapCoordinate(358, 238);
//        jinyang.setNeighbours(CITY_EMPTY, CITY_LUOYANG, CITY_EMPTY, CITY_YE, CITY_EMPTY, CITY_JI, CITY_EMPTY, CITY_EMPTY);
//        ye.setMapCoordinate(440, 261);
//        ye.setNeighbours(CITY_EMPTY, CITY_CHENLIU, CITY_JINYANG, CITY_PINGYUAN, CITY_EMPTY, CITY_NANPI, CITY_EMPTY, CITY_PUYANG);
//        nanpi.setMapCoordinate(488, 207);
//        nanpi.setNeighbours(CITY_EMPTY, CITY_PINGYUAN, CITY_EMPTY, CITY_EMPTY, CITY_JI, CITY_BEIPING, CITY_YE, CITY_BEIHAI);
//        pingyuan.setMapCoordinate(500, 246);
//        pingyuan.setNeighbours(CITY_NANPI, CITY_EMPTY, CITY_YE, CITY_BEIHAI, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY, CITY_EMPTY);
//        beihai.setMapCoordinate(607, 248);
//        beihai.setNeighbours(CITY_EMPTY, CITY_XIAPI, CITY_PINGYUAN, CITY_EMPTY, CITY_NANPI, CITY_EMPTY, CITY_PUYANG, CITY_EMPTY);
//         
//        // Initialise City List.
//        cityList.add(xiangping);
//        cityList.add(beiping);
//        cityList.add(ji);
//        cityList.add(jinyang);
//        cityList.add(ye);
//        cityList.add(nanpi);
//        cityList.add(pingyuan);
//        cityList.add(beihai);
//        cityList.add(luoyang);
//        cityList.add(xuchang);      // 10
//        cityList.add(chenliu);
//        cityList.add(puyang);
//        cityList.add(xiaopei);
//        cityList.add(xiapi);
//        cityList.add(runan);
//        cityList.add(shouchun);
//        cityList.add(wan);
//        cityList.add(xiliang);
//        cityList.add(tianshui);
//        cityList.add(hanzhong);     // 20
//        cityList.add(changan);
//        cityList.add(lujiang);
//        cityList.add(jianye);
//        cityList.add(wu);
//        cityList.add(chaisang);
//        cityList.add(kuaiji);
//        cityList.add(xinye);
//        cityList.add(xiangyang);
//        cityList.add(shangyong);
//        cityList.add(jiangxia);       // 30
//        cityList.add(jiangling);
//        cityList.add(wuling);
//        cityList.add(changsha);
//        cityList.add(lingling);
//        cityList.add(guiyang);
//        cityList.add(zitong);
//        cityList.add(chengdu);
//        cityList.add(jiangzhou);
//        cityList.add(yongan);
//        cityList.add(yunnan);       // 40
	}
}
