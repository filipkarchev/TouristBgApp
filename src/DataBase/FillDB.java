package DataBase;

import android.content.Context;

public class FillDB {
	private Context context;

	String name, description, picture, hours, telephone, latitude, longitude;
	Float rayting;
	String isVisited = "false";

	public FillDB(Context cnt) {
		this.context = cnt;
	}

	public void fill() {
		

		DataBase.ObjectDAO obj = new ObjectDAO(context);
		
		
		name = "Храм-паметник „Александър Невски“";
		description = "Най-величественият и монументален символ на град София. Най-големият действащ православен храм в България и втори по големина на Балканския полуостров. Построен е в памет на руските воини, загинали за освобождението на България през Руско-турската война (1877-1878 г.). Посветен е на руския герой и светец Ал. Невски.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/ebe9ac202a3149b75a8ae8adb2e1d8a7_XL.jpg";
		hours = "понеделник – неделя: 07:00 – 19:00 ч.";
		telephone = "+359 2 9881704";
		rayting = (float) 4.5;
		latitude="42.695805";
		longitude="23.332802";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "Къща-музей „Хаджи Димитър“";
		description = "Къщата-музей в сливенския квартал Клуцохор. Пресъздава обстановката, в която е израсъл легендарният войвода. Тя е малка, с дървен чардак и носи всички архитектурни белези на ранното Възраждане.\n\n";
		picture = "http://bulgariatravel.org/data/media/218_001_Kyshta-muzej_Hadji_Dimityr.jpg";
		hours = "Април – октомври: 9.00 - 12.00 ч. : 14.00 – 17.00 ч."
				+ "/n(без почивен ден)"
				+ "/nНоември - март: 9.00 - 12.00 ч. : 14.00 – 17.00 ч."
				+ "/nПочивен ден: – неделя";
		telephone = "044/ 62 24 96";
		rayting = (float) 5;
		latitude="42.6784961";
		longitude="26.3117380";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "Белоградчишки скали";
		description = "Преди около 230 милиона години в този район се наслоили песъчливо-мергелни скали. По-късно те били залети от море, на дъното на което се отлагали довлечените от реките пясък, чакъл и глина. Така се получили конгломерати, известни като пъстър пясъчник. От железния окис те придобили червеникав оттенък. Върху тях през юрския период се наслоили сиви и кремавобели варовици. При нагъването на Стара планина този район се превърнал в суша. В най-високата му част се появили пукнатини, където започнала разрушителната работа на водата, ветровете и колебанията на температурата. Поради нееднаквата си твърдост, пясъчниците се рушели неравномерно. Така се появила тази невероятно красива скална феерия.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/8fe3e0f34d3083cba6fe73d62a783d7f_XL.jpg";
		hours = "всеки ден - 09:00 - 18:00 ч.";
		telephone = "09363001";
		rayting = (float) 4.7;
		latitude="43.611554";
		longitude="22.677120";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "Национален парк-музей „Самуилова крепост“";
		description = "Самуиловата крепост се намира на десния бряг на река Струмешница, в полите на Беласица. На това място през 1014 г. се е разиграла една от най-големите трагедии в историята на българската държава.\n\n";
		picture = "http://www.atlas-s.com/images/info/samuilova%20krepost2.jpg";
		hours = "08:00 - 17:00 ч.";
		telephone = "+359 887 112 504";
		rayting = (float) 4;
		latitude="41.394568";
		longitude="23.028718";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "Национален парк-музей „Шипка“ - паметник на свободата";
		description = "Храмът е построен в стила на руските църкви от 17-ти век. Петте позлатени купола - четири странични с височина 33 метра и централният, който се извисява на 42 метра, имат традиционната форма на луковица. Общото тегло на 17-те камбани, украсени с орнаменти, надхвърля 20 тона, като най-голямата тежи 11 643 килограма. На празници сладкогласният им ек се носи от долината на Казанлък чак до билото на планината.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/817a0b87c8b4a5b09390d4c2ae24ca96_XL.jpg";
		hours = "април – октомври: 9 ч. – 19 ч.\nноември – март: 9 ч. – 17 ч.,";
		telephone = "+359 43162495";
		rayting = (float) 4.9;
		latitude="42.747138";
		longitude="25.321684";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "пещера „Снежанка“";
		description = "С право е наричана една от най-красивите пещери. Снежнобелият цвят на дребнозърнестите мрамори, които е прорязала Новомахленска река преди повече от 3,5 милиона години, за да създаде това природно чудо, я прави неповторима. Оттам идва и името на пещерата, защото в така наречената Вълшебна зала, сред изящните синтрови образувания и езера, очарованото око с лекота различава фигурата на Снежанка, балдахина на нейното легло и други детайли от любимата приказка, сътворени сякаш от феерична снежнобяла материя.\n\n";
		picture = "http://bghotelite.com/images/zabelejitelnosti/1/12/1.jpg";
		hours = "От 1 Април до 30 септември: 9:30 - 17:15 ч. \n От 1 Октоври -31 март: 9:30 - 16:00 ч.";
    	telephone = "0896715971";
		rayting = (float) 5;
		latitude="42.007111";
		longitude="24.282517";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "Пловдив – Античен театър";
		description = "Най-емблематичният паметник в архитектурно-историческия резерват \"Старият Пловдив\" все пак си остава прочутият Античен театър. Смята се, че е построен от Марк Аврелий Траян в началото на II век /макар да съществува и предположение, че може би е бил изграден още преди римската епоха по подобие на гръцките антични театри, за да послужи за народните празненства и обреди в чест на бог Дионисий/.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/cd66a7a18d37d7e5dd969c249e9a1ecb_XL.jpg";
		hours = "Всеки ден: 9:00 – 17:30.";
    	telephone = "+359 888 679079";
		rayting = (float) 3.8;
		latitude="42.146885";
		longitude="24.751166";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);
		
	}
}
