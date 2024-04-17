package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao {

	private String baseSql;

	public Student get(String no) throws Exception {

	}

	private List<Student> postFilter(ResultSet rSet, School school) throws Exception{
		//リストを初期化
		List<Student> list = new ArrayList<>();
		try {
			//リザルトセットを全権走査
			while (rSet.next()){
				//全学年インスタンスを初期化
				Student student = new Student();
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(school);
				//リストに追加
				list.add(student);
			}
		} catch (SQLException | NullPointerException e){
			e.printStackTrace();
		}

		return list;
	}

	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception {
		// リストを初期化
		List<Student> list = new ArrayList<>();
		//コネクションを確率
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//リザルトセット
		ResultSet rSet = null;
		//SQL文の条件
		String condition = "and ent_year=? and class_num=?";
		//SQL文のソート
		String order = " order by no asc";

		//SQL文の在学フラグ条件
		String conditionIsAttend = "";
		//在学フラグがtrueの場合
		if (isAttend) {
			conditionIsAttend = "and is_attend=true";
		}
	}

	try {
		//ぷリペアーとステートメントにSQL文をセット
		statement = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
	}

	public List<Student> filter (School school, int entYear, boolean isAttend) throws Exception {

	}

	public List<Student> filter(School school, boolean isAttend) throws Exception {

	}

	public boolean save(Student student) throws Exception{

	}
}

