package poi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApplication {
	public static final String FILE_BEFORE_2003 = "./src/CustomerInfo.xls";
	public static final String FILE_AFTER_2007 = "./src/CustomerInfo.xlsx";

	Map<String, CustomerVo> customerMap;
	Scanner scanner;

	public MainApplication() {
		customerMap = new HashMap<>();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new MainApplication().startRegister();
	}

	private void startRegister() {
		while (true) {
			int choice = selectMenu();
			switch (choice) {
			case 1: // 회원가입
				register();
				break;
			case 2: // 정보 조회
				show();
				break;
			case 3: // 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
				break;
			}
		}
	}

	private int selectMenu() {
		System.out.println("==============================================================\n");
		System.out.println("  ___                       _            ______  _____  _____ ");
	    System.out.println(" / _ \\                     | |           | ___ \\|  _  ||_   _|");
	    System.out.println("/ /_\\ \\ _ __    __ _   ___ | |__    ___  | |_/ /| | | |  | |  ");
	    System.out.println("|  _  || '_ \\  / _` | / __|| '_ \\  / _ \\ |  __/ | | | |  | |  ");
	    System.out.println("| | | || |_) || (_| || (__ | | | ||  __/ | |    \\ \\_/ / _| |_ ");
	    System.out.println("\\_| |_/| .__/  \\__,_| \\___||_| |_| \\___| \\_|     \\___/  \\___/ ");
	    System.out.println("       | |                                                    ");
	    System.out.println("       |_|                                                    \n");
	    System.out.println("             1. 회원가입  2. 회원정보 조회  3. 프로그램 종료\n");
	    System.out.println("==============================================================");
		System.out.print("메뉴를 선택하세요 >> ");
		return Integer.parseInt(scanner.nextLine());
	}

	private void register() {
		System.out.println("\n--------------------------------------------------------------\n");
		System.out.println("                         [ 회 원 가 입 ]\n");
		System.out.println("                       고객 정보를 입력하세요\n");
		
		System.out.print("                아이디: ");
		String id = scanner.nextLine();

		System.out.print("                비밀번호: ");
		String password = scanner.nextLine();

		System.out.print("                이름: ");
		String name = scanner.nextLine();

		System.out.print("                이메일: ");
		String email = scanner.nextLine();

		System.out.print("                전화번호: ");
		String telno = scanner.nextLine();
		
		customerMap.put(id, new CustomerVo(id, password, name, email, telno));
		createExcelFile();
		
		System.out.println("\n                     * 회원가입이 완료되었습니다 *");
		System.out.println("\n--------------------------------------------------------------\n");

	}

	private void createExcelFile() {
		// CustomerExcelWriter클래스 인스턴스 생성 => excelWriter에 할당
		CustomerExcelWriter excelWriter = new CustomerExcelWriter();

		// xls 파일 쓰기(2003)
		excelWriter.createExcelFileBefore2003(customerMap);

		// xlsx 파일 쓰기(2007)
		excelWriter.createExcelFileAfter2007(customerMap);
	}

	private void show() {
		CustomerExcelReader excelReader = new CustomerExcelReader();
		excelReader.reader();
	}
}
