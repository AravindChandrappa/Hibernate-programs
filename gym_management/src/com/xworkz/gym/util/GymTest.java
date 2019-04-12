
package com.xworkz.gym.util;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.SFutil.SFutil;
import com.xworkz.gym.dao.GymDAO;
import com.xworkz.gym.dao.GymDAOImpl;
import com.xworkz.gym.dto.GymDTO;

public class GymTest {

	public static void main(String[] args) {

		// GymDTO dto=new GymDTO("moongym","rajajinagar","both");
		GymDAO dao = new GymDAOImpl();
		List<GymDTO> list = dao.fetchAllRecordsFromDb();
		// System.out.println(list.toString());
		System.out.println("FetchAllRecords method records");
		if (list != null) {
			/*for (GymDTO gymDTO : list) {
				System.out.println(gymDTO);

			}*/

			list.forEach(entity -> System.out.println(entity));

		}
		System.out.println("------------------------");
		dao.fetchByNameAndLoctaion("phoneix").forEach(entity -> System.out.println("Location: " + entity));

		System.out.println("------------------------\n");
		
		List<Object[]> list2 = dao.fetchAllLocationAndType("both");
		for (Object[] object : list2) {
			System.out.print(object[0] + "\t");
			System.out.println(object[1]);
		}
		System.out.println("-----------------------\n");
		List<Object[]> list3 = dao.fetchAllGymNameAndLocationByParam();
		for (Object[] objects : list3) {
			System.out.println(objects[0] + "\t" + objects[1]);
		}
		System.out.println("-----------------------\n");

		dao.updateLocationByName("maruthi", "RTnagar");
		//System.out.println("Successfully update in id: "+id);
		
		System.out.println("-----------------------\n");
		//dao.deleteRecordByType("mens");
		
		GymDTO dto=new GymDTO();
		dto.setG_name("Tgym");
		dto.setLoctaion("america");
		dto.setType("mens");
		
		GymDTO dto2=new GymDTO("workout","mangalore","both");
		GymDTO dto3=new GymDTO("sixpack","bagepalli","mens");
		GymDTO dto4=new GymDTO("slimLook","bangalore","womens");
		
		List<GymDTO> gList=new ArrayList<GymDTO>();

		gList.add(dto);
		gList.add(dto2);
		gList.add(dto3);
		gList.add(dto4);
		
		
		
		//dao.insertValues(gList);		
		//dao.insertValues(dto);
		SFutil.close();
	}

}
