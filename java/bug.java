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

//=================================================================-
