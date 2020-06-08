import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class Member_Test {
	
	Member member = new Member("クレスコ明日","cresco1234");
	
	@Test //ユーザーIDを参照する
	public void test1() {
	String actual = "クレスコ明日";
	assertThat(actual,is(member.getMemberID()));
	}
	
	@Test //パスワードを参照する
	public void test2() {
	String actual = "cresco1234";
	assertThat(actual,is(member.getMmberPass()));		
	}
}
