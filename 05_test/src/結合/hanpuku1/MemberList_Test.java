import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MemberList_Test {
	
	@Test //ユーザーIDが一致していた場合
	public void test1() {
		MemberList memberList= new MemberList("クレスコ明日","cresco1234");
		Member actual = memberList.checkID("クレスコ明日");
		assertThat(actual,is(memberList.getMember(0)));	
	}
	
	@Test //ユーザーIDが一致していない場合
	public void test2() {
		MemberList memberList = new MemberList("クレスコ明日","cresco1234");
		Member actual = memberList.checkID("クレスコ今日");
		assertNull(actual);	
	}
}