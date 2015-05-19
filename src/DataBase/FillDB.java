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
		
		
		name = "����-�������� ����������� ������";
		description = "���-�������������� � ������������ ������ �� ���� �����. ���-�������� �������� ����������� ���� � �������� � ����� �� �������� �� ���������� ����������. �������� � � ����� �� ������� �����, �������� �� �������������� �� �������� ���� �����-�������� ����� (1877-1878 �.). �������� � �� ������ ����� � ������ ��. ������.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/ebe9ac202a3149b75a8ae8adb2e1d8a7_XL.jpg";
		hours = "���������� � ������: 07:00 � 19:00 �.";
		telephone = "+359 2 9881704";
		rayting = (float) 4.5;
		latitude="42.695805";
		longitude="23.332802";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "����-����� ������ �������";
		description = "������-����� � ���������� ������� ��������. ���������� ������������, � ����� � ������� ������������ �������. �� � �����, � ������ ������ � ���� ������ ������������ ������ �� ������� ����������.\n\n";
		picture = "http://bulgariatravel.org/data/media/218_001_Kyshta-muzej_Hadji_Dimityr.jpg";
		hours = "����� � ��������: 9.00 - 12.00 �. : 14.00 � 17.00 �."
				+ "/n(��� ������� ���)"
				+ "/n������� - ����: 9.00 - 12.00 �. : 14.00 � 17.00 �."
				+ "/n������� ���: � ������";
		telephone = "044/ 62 24 96";
		rayting = (float) 5;
		latitude="42.6784961";
		longitude="26.3117380";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "������������� �����";
		description = "����� ����� 230 ������� ������ � ���� ����� �� �������� ���������-�������� �����. ��-����� �� ���� ������ �� ����, �� ������ �� ����� �� �������� ����������� �� ������ �����, ����� � �����. ���� �� �������� ������������, �������� ���� ������ ��������. �� �������� ���� �� ��������� ���������� �������. ����� ��� ���� ������ ������ �� �������� ���� � ����������� ��������. ��� ���������� �� ����� ������� ���� ����� �� ��������� � ����. � ���-�������� �� ���� �� ������� ���������, ������ ��������� �������������� ������ �� ������, ��������� � ����������� �� �������������. ������ ����������� �� ��������, ����������� �� ������ ������������. ���� �� ������� ���� ���������� ������� ������ ������.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/8fe3e0f34d3083cba6fe73d62a783d7f_XL.jpg";
		hours = "����� ��� - 09:00 - 18:00 �.";
		telephone = "09363001";
		rayting = (float) 4.7;
		latitude="43.611554";
		longitude="22.677120";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "���������� ����-����� ���������� �������";
		description = "����������� ������� �� ������ �� ������ ���� �� ���� �����������, � ������ �� ��������. �� ���� ����� ���� 1014 �. �� � ��������� ���� �� ���-�������� �������� � ��������� �� ����������� �������.\n\n";
		picture = "http://www.atlas-s.com/images/info/samuilova%20krepost2.jpg";
		hours = "08:00 - 17:00 �.";
		telephone = "+359 887 112 504";
		rayting = (float) 4;
		latitude="41.394568";
		longitude="23.028718";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "���������� ����-����� ������� - �������� �� ���������";
		description = "������ � �������� � ����� �� ������� ������ �� 17-�� ���. ����� ��������� ������ - ������ ��������� � �������� 33 ����� � �����������, ����� �� �������� �� 42 �����, ���� ������������� ����� �� ��������. ������ ����� �� 17-�� �������, �������� � ���������, ��������� 20 ����, ���� ���-�������� ���� 11 643 ���������. �� �������� �������������� �� �� �� ���� �� �������� �� �������� ��� �� ������ �� ���������.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/817a0b87c8b4a5b09390d4c2ae24ca96_XL.jpg";
		hours = "����� � ��������: 9 �. � 19 �.\n������� � ����: 9 �. � 17 �.,";
		telephone = "+359 43162495";
		rayting = (float) 4.9;
		latitude="42.747138";
		longitude="25.321684";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "������ ����������";
		description = "� ����� � �������� ���� �� ���-��������� ������. ������������ ���� �� ���������������� �������, ����� � ��������� ������������� ���� ����� ������ �� 3,5 ������� ������, �� �� ������� ���� �������� ����, � ����� �����������. ����� ���� � ����� �� ��������, ������ � ���� ���������� �������� ����, ���� �������� �������� ����������� � �����, ����������� ��� � ������ ��������� �������� �� ��������, ��������� �� ������� ����� � ����� ������� �� �������� ��������, ��������� ����� �� �������� ���������� �������.\n\n";
		picture = "http://bghotelite.com/images/zabelejitelnosti/1/12/1.jpg";
		hours = "�� 1 ����� �� 30 ���������: 9:30 - 17:15 �. \n �� 1 ������� -31 ����: 9:30 - 16:00 �.";
    	telephone = "0896715971";
		rayting = (float) 5;
		latitude="42.007111";
		longitude="24.282517";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);

		name = "������� � ������� ������";
		description = "���-�������������� �������� � ������������-������������ �������� \"������� �������\" ��� ��� �� ������ ��������� ������� ������. ����� ��, �� � �������� �� ���� ������� ����� � �������� �� II ��� /����� �� ���������� � �������������, �� ���� �� � ��� �������� ��� ����� �������� ����� �� ������� �� �������� ������� ������, �� �� ������� �� ��������� ����������� � ������ � ���� �� ��� ��������/.\n\n";
		picture = "http://100nto.org/media/k2/items/cache/cd66a7a18d37d7e5dd969c249e9a1ecb_XL.jpg";
		hours = "����� ���: 9:00 � 17:30.";
    	telephone = "+359 888 679079";
		rayting = (float) 3.8;
		latitude="42.146885";
		longitude="24.751166";
		obj.createObject(name, description, picture, hours, telephone, rayting,
				latitude,longitude,isVisited);
		
	}
}
