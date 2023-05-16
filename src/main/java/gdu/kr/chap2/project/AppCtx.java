package gdu.kr.chap2.project;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gdu.kr.chap2.BuildRunner;
import gdu.kr.chap2.Project;
@Configuration //컨테이너 클래스 선언
//gdu.kr.chap2 패키지 중 @Component인 클래스의 객체 생성 = <context:component-scan..../>
@ComponentScan(basePackages = {"gdu.kr.chap2"})
public class AppCtx {

	@Bean
	public Project project() {
		Project p = new Project();
		p.setBindir("bin");
		p.setClasspath("src/");
		List<String> list = Arrays.asList("src/","srcResources/");
		p.setSrcdirs(list);
		p.setBuild(runner());
		return p;
	}
	@Bean
	private BuildRunner runner() {
		BuildRunner b = new BuildRunner();
		b.setPath("c:/setup/");
		return b;
	}
}
/* ======== 일반 자바 클래스에서 사용되는 어노테이션========
 * @Component : 객체 생성. 객체 주입이 완료.
 * @Autowired : 자료형 기준으로 의존성 주입(객체 주입). => 주입되는 객체가 없는 경우 : 오류 발생
 * 				객체가 없어도 허용 : @Autowired(required=false)
 * 				@Resource(name="이름") : 이름을 가진 객체 주입
 * @Scope	  : 일회성 객체 생성
 * ======== 환경설정 자바 클래스에서 사용되는 어노테이션========
 * @Configuration : 환경 설정 자바 클래스. xml 대체 클래스		
 * @ComponentScan(basePackages = {"gdu.kr.chap2"}) : 객체생성을 위한 패키지 scan 설정
 * @Bean : <bean id=""... /> 환경 설정 자바 클래스에서 메서드에 사용됨.
 * 			리턴타입에 해당하는 객체를 생성. 메서드의 이름으로 객체를 저장.
 * 
 */


