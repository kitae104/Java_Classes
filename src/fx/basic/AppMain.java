package fx.basic;

import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {

	private String ip;
	private String port;
	
	// 기본 생성자
	public AppMain() {
		System.out.println(Thread.currentThread().getName() + ": AppMain() 호출");
	}
	
	// 초기화 메소드 - 메인 클래스 실행 매개값 획득
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() 호출");
		
		Parameters params = getParameters();
		Map<String, String>map = params.getNamed();
		
		ip = map.get("ip");
		port = map.get("port");
		
		System.out.println("ip : " + ip);
		System.out.println("port : " + port);
		
	}

	// UI 관련 부분 처리 
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() 호출");

		VBox root = new VBox();
		
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		Label label = new Label("Hello, JavaFX");
		label.setFont(new Font(50));
		
		Button button = new Button();
		button.setText("확인");
		button.setOnAction(event -> Platform.exit());
		
		root.getChildren().add(label);
		root.getChildren().add(button);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("첫번째 JavaFX");
		primaryStage.setScene(scene);				// 신 설정하기 
		primaryStage.show(); 						// 윈도우 보여주기		
	}

	// 마무리 작성 시점에 호출 
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() 호출");
	}
	
	public static void main(String[] args) {
		Application.launch(args);	// 내부적으로 스레드 생성 
	}

}
