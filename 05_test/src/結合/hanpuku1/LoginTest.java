package TicketSystem;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LoginTest {
	@Test
	public void LoginTest1() {
		Control control = new Control();
		Interface ui = new Interface();
		MemberList memberList = new MemberList("クレスコ明日","12345");
		Member checkMember = memberList.getMember(0);
		
		Member member = control.login(ui, memberList);
		
		/* テスト結果の判定 */
		assertThat(member,is(checkMember));
	}
}

