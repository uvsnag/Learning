//1 List sẽ add địa chỉ của phần tử vào list, vì vậy khi giá tị của phần tử thay đổi thì giá trị trong list cũng sẽ thay đổi.
List<Cat> cats = new ArrayList<>();
    cats.add(new Cat("name1", 1));
    cats.add(new Cat("name2", 2));
    cats.add(new Cat("name3", 3));
    cats.add(new Cat("name4", 4));

final List<Monkey> monkeys = new ArrayList<>();
Monkey monkey = new Monkey();      // chỉ khởi tạo 1 lần
for (Cat c : cats) {
    // monkey = new Monkey(); // sửa bằng khởi tạo lại mỗi khi thực hiện add() xong.
    monkey.setAge(c.getAge());
    monkey.setName(c.getName());
    monkeys.add(monkey);
}
monkey.setName("rr"); //thay đổi giá trị của biến
monkeys.forEach(m -> {

    System.out.println(m.getName() + ";" + m.getAge());
});


output: 
rr;4
rr;4
rr;4
rr;4



//tương tự đối với Map object
// Object trong map sẽ thay đổi theo nếu biến tham chiếu thay đổi

public class Test {

	public static void main(String[] args) {
		 Map<String, Xe> soldiers = new HashMap<>();
		 Xe x1 =new Xe(1,2);
		 Xe x2 =new Xe(3,4);
		 
		 soldiers.put("s", x1);
		 soldiers.put("w", x2);
	    
		 Xe b = soldiers.get("s");
		 
		  System.out.println(b.getSoBanh()+","+b.getTocDo());
		  System.out.println(  soldiers.get("s").getSoBanh()+","+soldiers.get("s").getTocDo());
		  b.setSoBanh(6);
		  b.setTocDo(8);
		  System.out.println(b.getSoBanh()+","+b.getTocDo());
		  System.out.println(  soldiers.get("s").getSoBanh()+","+soldiers.get("s").getTocDo());
	}
}

class Xe {
	private int soBanh;

	private int tocDo;

	public Xe() {
		super();
	}

	public Xe(int soBanh, int tocDo) {
		this.soBanh = soBanh;
		this.tocDo = tocDo;
	}

	public int getSoBanh() {
		return soBanh;
	}

	public void setSoBanh(int soBanh) {
		this.soBanh = soBanh;
	}

	public int getTocDo() {
		return tocDo;
	}

	public void setTocDo(int tocDo) {
		this.tocDo = tocDo;
	}

}

// kết quả :
1,2
1,2
6,8
6,8

//=================================================================-
