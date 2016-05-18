package exam.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import exam.po.User;

@Repository
public class UserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据用户名获取用户对象
	 */
	public User getUser(String username){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TU.NAME,\n");
		sql.append("       TC.CODE_DESC GENDER,\n");
		sql.append("       TU.HAND_PHONE,\n");
		sql.append("       TU.EMAIL,\n");
		sql.append("       TU.BIRTHDAY,\n");
		sql.append("       TU.LASTSIGNIN_TIME,\n");
		sql.append("	   TU.PASSWORD \n");
		sql.append("  FROM TC_USER TU\n");
		sql.append("  LEFT JOIN TC_CODE TC ON TC.CODE_ID = TU.GENDER \n");
		sql.append("  WHERE TU.ACNT = ? ");
	
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), new Object[]{username});
		if(list.size() > 0){
			//只取第一条
			Map<String,Object> map = list.get(0);
			User user = new User();
			user.setName(map.get("NAME").toString());
			user.setGender(map.get("GENDER").toString());
			user.setBirthday(new Date(((Timestamp) map.get("BIRTHDAY")).getTime()));
			user.setEmail(map.get("EMAIL").toString());	
			user.setLastSinginTime(new Date(((Timestamp) map.get("LASTSIGNIN_TIME")).getTime()));
			user.setPhone(map.get("HAND_PHONE").toString());
			user.setPassword(map.get("PASSWORD").toString());
			return user;
		}else{
			return null;
		}
	}

	public void updateLastSingin(String username) {
		String sql = "UPDATE TC_USER SET LASTSIGNIN_TIME = SYSDATE WHERE ACNT = ? ";
		jdbcTemplate.update(sql, username);
	}	
}
