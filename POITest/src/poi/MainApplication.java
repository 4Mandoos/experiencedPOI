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
			case 3: // 정보 수정
				update();
				break;
			case 4: // 종료
				return;

			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	private int selectMenu() {
		System.out.println("——————————————");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원정보 조회");
		System.out.println("3. 회원정보 수정");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 >> ");
		return Integer.parseInt(scanner.nextLine());
	}

	private void register() {
		System.out.println("----회 원 가 입-----");
		System.out.println("고객 정보를 입력하세요");

		System.out.print("아이디: ");
		String id = scanner.nextLine();

		System.out.print("비밀번호");
		String password = scanner.nextLine();

		System.out.print("이름: ");
		String name = scanner.nextLine();

		System.out.print("이메일: ");
		String email = scanner.nextLine();

		System.out.print("전화번호: ");
		String telno = scanner.nextLine();

		customerMap.put(id, new CustomerVo(id, password, name, email, telno));

		createExcelFile();
	}

	private void createExcelFile() {
		// CustomerExcelWriter클래스 인스턴스 생성 => excelWriter에 할당
		CustomerExcelWriter excelWriter = new CustomerExcelWriter();

		// xls 파일 쓰기(2003)
		excelWriter.createExcelFileBefore2003(customerMap);

		// xlsx 파일 쓰기(2007)
		excelWriter.createExcelFileAfter2007(customerMap);
	}

	private void update() {
		// TODO Auto-generated method stub

	}

	private void show() {
		CustomerExcelReader excelReader = new CustomerExcelReader();
		excelReader.reader();
	}
}
