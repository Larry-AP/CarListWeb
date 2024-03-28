import java.util.List;
import java.util.Scanner;

import controller.CarInfoHelper;
import model.CarInfo;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CarInfoHelper cih = new CarInfoHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a make: ");
			String make = in.nextLine();
			System.out.print("Enter a model: ");
			String model = in.nextLine();
			System.out.print("Enter year: ");
			String year = in.nextLine();
			
			CarInfo toAdd = new CarInfo(make, model, year);
			cih.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the year to delete: ");
			String year = in.nextLine();
			
			CarInfo toDelete = new CarInfo(make, model, year); cih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<CarInfo> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the make: ");
				String makeName = in.nextLine();
				foundItems = cih.searchForItemByMake(makeName);
				}else{
				System.out.print("Enter the model: ");
				String modelName = in.nextLine();
				foundItems = cih.searchForItemByModel(modelName); }
		

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (CarInfo l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				CarInfo toEdit = cih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getMake());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				}

				cih.updateModel(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to my car list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the car program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					cih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			
			List<CarInfo> allItems = cih.showAllItems();
			for(CarInfo singleItem : allItems){
				System.out.println(singleItem.returnCarDetails());}
	}

	}