// -filter() method là một intermediate operation, cho phép chúng ta lọc các phần tử thoả các điều kiện được chỉ định

//Chuyển từ collections sang stream 
// -stream() : trả về một stream sẽ được xử lý theo tuần tự. Collection sẽ có thêm 2 phương thức này (stream(),parallelStream() ) trong interface.
// -parallelStream() : trả về một Stream song song, các xử lý sau đó sẽ thực hiện song song.

// -map() giúp ánh xạ các phần tử tới các kết quả tương ứng.
// -skip() được sử dụng để loại bỏ các phần tử n đầu tiên của Stream . Nếu Stream này chứa ít hơn n phần tử thì luồng trống sẽ được trả lại.
// -limit() được sử dụng để cắt giảm kích thước của Stream. Kết quả trả về các phần tử của Stream đã được cắt giảm để không vượt quá maxSize (tham số đầu vào của phương thức).
// -sorted() giúp sắp xếp các phần tử theo một thứ tự xác định.
// -forEach() giúp duyệt qua các phần tử của Stream.
// -collect() giúp thu thập kết quả Stream sang một Collection.
// -anyMatch() trả về một boolean tùy thuộc vào điều kiện được áp dụng trên Stream dữ liệu. Phương thức này trả về true ngay khi phần tử đầu tiên thõa mãn điều kiện, những phần tử còn lại sẽ không được kiểm tra.
// -allMatch() : Phương thức này trả về true nếu tất cả phần tử đều thõa mãn điều kiện. Nếu một phần tử không thõa điều kiện, những phần tử còn lại sẽ không được kiểm tra.
// -noneMatch() : Ngược lại với allMatch(), pương thức này trả về true nếu tất cả phần tử đều không thõa mãn điều kiện. Nếu một phần tử thõa điều kiện, những phần tử còn lại sẽ không được kiểm tra.
// -count() trả về tổng số phần tử cho dữ liệu luồng.
// -Stream.max(), Stream.max() chấp nhận đối số là một Comparator sao cho các item trong stream có thể được so sánh với nhau để tìm tối thiểu (min) hoặc tối đa (max).
// -reduce() kết hợp các phần tử luồng thành một bằng cách sử dụng một BinaryOperator.
// -findAny() cho phép chúng ta lấy một giá trị bất kỳ từ Stream mà không quan tâm đến thứ tự các phần tử trong nó. findAny() trả về Optional instance, nếu Stream rỗng thì findAny() trả về Empty Optional.
//         Khi findAny() hoạt động trên non-parallel Stream, thông thường nó sẽ trả về phần tử đầu tiên của Stream vì findAny() sẽ chọn phần tử dựa trên tập kết quả đã hoàn tất các hoạt động trung gian, tuy nhiên cũng có thể xuất hiện kết quả khác không ai đảm bảo cho chúng ta điều đó.
// -findFirst() khi muốn tìm phần tử đầu tiên trong Stream. Tuy nhiên Stream có thể không định nghĩa thứ tự các phần tử, điều này phụ thuộc vào nguồn tài nguyên và các hoạt động trung gian. Khi không được định nghĩa thứ tự, findFirst() cũng sẽ trả về phần tử bất kỳ trong Stream.
//        Chúng ta thường sử dụng findFirst() khi chắc rằng sau khi Stream trải qua các hoạt động trung gian thì chỉ còn duy nhất một phần tử hoặc đã qua hoạt động sắp xếp.
// -Stream.map() Là phương thức mạnh hỗ trợ việc map từng phần tử của danh sách với đối tượng khác.
// -collect() làm một trong những phương thức xử lý tiêu biểu của interface Stream. Khi phương thức này được gọi thì việc filter hay mapping ở hai ví dụ trên mới thực sự được thực hiện


// *other method :https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

// tham khao them https://viblo.asia/p/tuot-tuon-tuot-ve-stream-trong-java8-Qbq5QvwwKD8   (rat hay)


// -Việc truy cập các biến phạm vi bên ngoài từ các biểu thức lambda rất giống với các đối tượng ẩn danh (anonymous objects). Bạn có thể truy cập bất kỳ biến final, static hoặc biến chỉ được gán một lần. B
//      Lambda throw một lỗi biên dịch, nếu một biến được gán một giá trị lần thứ hai.


// So sánh sự khác nhau giữa Collections và Streams
// Lưu trữ – Java Stream không giống như các Collection không lưu trữ bất kỳ dữ liệu nào.
// Tính toán – Các phần tử trong các Collection được tính toán trước khi được thêm vào Collection, trong khi các phần tử stream được tính theo yêu cầu nếu chúng được sử dụng.
// Kích thước – Collection chứa số lượng phần tử hữu hạn, trong khi Stream có khả năng vô hạn.
// Mức tiêu thụ – Các phần tử trong Stream chỉ có thể được sử dụng một lần, tương tự như iterator. Các phần tử trong Collection có thể được dùng nhiều lần như mong muốn.
// Iteration – Việc lặp lại trên các collection được thực hiện bên ngoài (bởi người dùng) trong khi Stream sử dụng lặp lại nội bộ và xử lý việc này cho bạn. Do đó việc debug khá khó khăn trên Streams do việc lặp nội bộ.


// 1.
/*  Ví dụ biểu thức Lambda không có tham số */
public class Test {
	public static void main(String[] args) {
		Sayable1 s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());
        //vìa Sayable1 là FunctionalInterface nên hàm sẽ tự nhận 
        // chuỗi str thành tham số của hàm duy nhất
	}

}
@FunctionalInterface
//FunctionalInterface chỉ có 1 function trong interface
interface Sayable1 {
	public String say();
}

//----------------------------------------------------------------------------

//2
/* Ví dụ biểu thức Lambda có một tham số duy nhất */
package com.tip.common;

public class Test {

	public static void main(String[] args) {

		  // Lambda expression with single parameter.
        Sayable2 s1 = (name) -> {
            return "Hello, " + name;
        };
        System.out.println(s1.say("GP Coder"));
 
        // Shorter
        Sayable2 s2 = name -> {
            return "Hello, " + name;
        };
        System.out.println(s2.say("GP Coder"));
 
        // Shortest
        Sayable2 s3 = name -> "Hello, " + name;
        System.out.println(s3.say("GP Coder"));
	}

}

@FunctionalInterface
interface Sayable2 {
    public String say(String name);
}
 
 //----------------------------------------------------------------------------

 //3.
/*  Ví dụ biểu thức Lambda có nhiều tham số, sử dụng hoặc không sử dụng từ khóa return */

package com.tip.common;

public class Test {

	public static void main(String[] args) {

		   // Multiple parameters with data type in lambda expression
        Addable ad1 = (int a, int b) -> (a + b);
        System.out.println(ad1.add(10, 20));
 
        // Multiple parameters in lambda expression
        Addable ad2 = (a, b) -> (a + b);
        System.out.println(ad2.add(10, 20));
 
        // Lambda expression with return keyword.
        Addable ad4 = (a, b) -> {
            return (a + b);
        };
        System.out.println(ad4.add(10, 20));
 
        // Lambda expression without return keyword.
        Addable ad5 = (a, b) -> (a + b);
        System.out.println(ad5.add(10, 20));
 
        // Lambda expression with multi-statement
        Addable ad6 = (a, b) -> {
            int sum = (a + b);
            return sum;
        };
        System.out.println(ad6.add(10, 20));
	}

}

@FunctionalInterface
interface Addable {
    int add(int a, int b);
}
 
 //----------------------------------------------------------------------------

//4
/* Ví dụ biểu thức Lambda với vòng lặp Foreach */

	public static void main(String[] args) {

		List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

		// Using Lambda expression
		languages.forEach(n -> System.out.println(n));
	}


 //----------------------------------------------------------------------------

//5
/* Ví dụ biểu thức Lambda tạo Thread */

public static void main(String[] args) {

		// Using an anonymous inner class
		Runnable r1 = new Runnable() {
            //Runnable : tham khao https://viettuts.vn/java-thread/tao-thread-trong-java
			//Runnable.run() cũng là @FunctionalInterface nên chỉ có 1 hàm
            public void run() {
				System.out.println("Runnable 1");
			}
		};

		// Using Lambda Expression for Funcational Interface
		Runnable r2 = () -> System.out.println("Runnable 2");

		r1.run();
		r2.run();
	}

 //----------------------------------------------------------------------------

//6
/* Ví dụ biểu thức Lambda với Filter Collection Data */

package com.tip.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "Samsung A5", 17000f));
		list.add(new Product(3, "Iphone 6S", 65000f));
		list.add(new Product(2, "Sony Xperia", 25000f));
		list.add(new Product(4, "Nokia Lumia", 15000f));
		list.add(new Product(5, "Redmi4 ", 26000f));
		list.add(new Product(6, "Lenevo Vibe", 19000f));

		// using lambda to filter data
		Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);

		// using lambda to iterate through collection
		filtered_data.forEach(product -> System.out.println(product.name + ": " + product.price));
	}

}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

//----------------------------------------------------------------------------

//7
/* Streams filter(), findAny() and orElse()  */
public static void main(String[] args) {

		  List<Person> persons = Arrays.asList(
	                new Person("mkyong", 30),
	                new Person("jack", 20),
	                new Person("lawrence", 40)
	        );

	        Person result1 = persons.stream()                        // Convert to steam
	                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
	                .findAny()                                      // If 'findAny' then return found
	                .orElse(null);                                  // If not found, return null

	        System.out.println(result1);

	        Person result2 = persons.stream()
	                .filter(x -> "ahmook".equals(x.getName()))
	                .findAny()
	                .orElse(null);

	        System.out.println(result2);
	        }

}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}


    //gettersm setters, toString
}
 //----------------------------------------------------------------------------

//8
/* Đối với trường hợp nhiều đối tượng */

public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);

    }
 //----------------------------------------------------------------------------

//9
/* Streams filter() and map() */
public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

    }

}

//

public class MapStreamExample {
 
    // map() operation helps map elements to the corresponding results
    public static void main(String[] args) {
        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
 
        data.stream() //
                .map(String::toUpperCase) // convert each element to upper case
                .forEach(System.out::println);
    }
}

//===============================Predicate trong Java 8============================
// Trong Java 8, Predicate<T> là một functional interface và do đó nó có thể được sử dụng với lambda expression hoặc method reference cho một mục đích cụ thể nào đó. Predicate<T> sẽ trả 
// về giá trị true/false của một tham số kiểu T mà bạn đưa vào có thỏa với điều kiện của Predicate đó hay không, cụ thể là điều kiện được viết trong phương thức test().

// - test() trả về true nếu đối số đầu vào khớp với biến predicate (điều kiện kiểm tra), nếu không trả về false.
// - and() : Nó thực hiện logic AND của predicate mà nó được gọi với một biến predicate khác. Ví dụ: predicate1.and (predicate2).
// - or() : Nó thực hiện logic OR của predicate mà nó được gọi với một biến predicate khác. Ví dụ: predicate1.or(predicate2).
// - negate() : Nó thực hiện phủ định kết quả của biến predicate được gọi. Ví dụ: predicate1.negate().
// - isEqual() Phương thức này được sử dụng để kiểm tra hai đối có số bằng nhau theo Objects.equals (Object, Object).


//1
/* Sử dụng test() */

package com.tip.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		// Predicate String
        Predicate<String> predicateString = s -> {
            return s.equals("gpcoder");
        };
        System.out.println(predicateString.test("gpcoder")); // true
        System.out.println(predicateString.test("GP Coder")); // false
 
        // Predicate integer
        Predicate<Integer> predicateInt = i -> {
            return i > 0;
        };
        System.out.println(predicateInt.test(1)); // true
        System.out.println(predicateInt.test(-1)); // false
	}

}

//----------------------------------------------------------------------------

//2
/* Sử dụng and(), or(), negate(), isEqual() */

public static void main(String[] args) {
		 Predicate<String> predicate = s -> {
	            return s.equals("gpcoder");
	        };
	 
	        // AND logical operation
	        Predicate<String> predicateAnd = predicate.and(s -> s.length() == 11);
	        System.out.println(predicateAnd.test("gpcoder.com")); // true
	 
	        // OR logical operation
	        Predicate<String> predicateOr = predicate.or(s -> s.length() == 11);
	        System.out.println(predicateOr.test("gpcoder.com")); // true
	 
	        // NEGATE logical operation
	        Predicate<String> predicateNegate = predicate.negate();
	        System.out.println(predicateNegate.test("gpcoder")); // false
	}


//----------------------------------------------------------------------------

//3
/* Kết hợp nhiều Predicate */

public static void main(String[] args) {
		 // Creating predicate
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lessThanTwenty = (i) -> i < 20;
 
        // Calling Predicate Chaining
        boolean result = greaterThanTen.and(lessThanTwenty).test(15);
        System.out.println(result); // true
 
        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lessThanTwenty).negate().test(15);
        System.out.println(result2); // false
	}

//----------------------------------------------------------------------------

//4
/* Sử dụng Predicate vơi Collection */

public class Test {

	public static void main(String[] args) {
		   List<Employee> employees = Arrays.asList( //
	                new Employee(1, 23, "M", "Rick", "Beethovan"), //
	                new Employee(2, 13, "F", "Martina", "Hengis"), //
	                new Employee(3, 43, "M", "Ricky", "Martin"), //
	                new Employee(4, 26, "M", "Jon", "Lowman"), //
	                new Employee(5, 19, "F", "Cristine", "Maria"), //
	                new Employee(6, 15, "M", "David", "Feezor"), //
	                new Employee(7, 68, "F", "Melissa", "Roy"), //
	                new Employee(8, 79, "M", "Alex", "Gussin"), //
	                new Employee(9, 15, "F", "Neetu", "Singh"), //
	                new Employee(10, 45, "M", "Naveen", "Jain") //
	        );
	 
	        // Lấy danh sách Employee nam 21+
	        System.out.println(filterEmployees(employees, isAdultMale()));
	 
	        // Lấy danh sách Employee nữ 18+
	        System.out.println(filterEmployees(employees, isAdultFemale()));
	 
	        // Lấy danh sách Employee > 35 tuổi
	        System.out.println(filterEmployees(employees, isAgeMoreThan(35)));
	 
	        // Lấy danh sách Employee <= 35 tuổi
	        System.out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));
	    
	}

}
public class Employee {
	 
    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;
 
    public Employee(Integer id, Integer age, String gender, String fName, String lName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }
 
    @Override
    public String toString() {
        return this.id.toString() + " - " + this.age.toString();
    }
 
    // Please generate Getter and Setters
}
public class EmployeePredicates {
	 
    // Tất cả Employee có tuổi > 21 và có giới tính là Male
    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }
 
    // Tất cả Employee có tuổi > 18 và có giới tính là Female
    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }
 
    // Tất cả Employee lớn hơn số tuổi được truyền vào
    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }
 
    // Lấy danh sách Employee thõa mãn predicate được truyền vào
    public static List<Employee> filterEmployees( //
            List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
    }
}



//----------------------------------------------------------------------------

//5
/* Sử dụng Predicate với các lớp cho kiểu dữ liệu nguyên thủy (primitive type) */

// -IntPredicate : chấp nhận một giá trị kiểu Int duy nhất.
// -LongPredicate : chấp nhận một giá trị kiểu Long duy nhất.
// -DoublePredicate : chấp nhận một giá trị kiểu Double duy nhất


 public static void main(String[] args) {
 
        System.out.print("IntPredicate: ");
        int[] intNumbers = { 3, 5, 6, 2, 1 };
        IntPredicate intPredicate = i -> i > 5;
        Arrays.stream(intNumbers).filter(intPredicate).forEach(System.out::println);
 
        System.out.print("\nLongPredicate: ");
        long[] longNumbers = { 3, 5, 6, 2, 1 };
        LongPredicate longPredicate = l -> l > 5;
        Arrays.stream(longNumbers).filter(longPredicate).forEach(System.out::println);
 
        System.out.print("\nDoublePredicate: ");
        double[] dbNumbers = { 3.2, 5.0, 6.3, 2.5, 1.0 };
        DoublePredicate dbPredicate = d -> d > 5;
        Arrays.stream(dbNumbers).filter(dbPredicate).forEach(System.out::println);
    }


//----------------------------------------------------------------------------

//6
/* Sử dụng Predicate 2 đối số với BiPredicate */

// Predicate chỉ chấp nhận 1 đối số đầu vào và trả về 1 giá trị true/false, để có thể sử dụng Predicate với 2 đối số 
// đầu vào chúng ta sử dụng Interface BiPredicate:

// Về cơ bản, interface BiPredicate không khác biệt so với Predicate, ngoại trừ nó chấp nhận 2 đối số đầu vào.

 public static void main(String[] args) {
 
        BiPredicate<Integer, String> condition = (i, s) -> i > 2 && s.startsWith("J");
        System.out.println(condition.test(5, "Java")); // true
        System.out.println(condition.test(2, "Javascript")); // false
        System.out.println(condition.test(1, "C#")); // false
    }

//===========================================EXAMPLE======================================================


//1  stream find object
	p = retList.stream()
    .filter(p -> Objects.equals(p.getId(), "2"))
    .findFirst()
    .get(); //findfirst trả về optional

//2 stream find object (return)
		final Map<String, Object> ct = list.stream()
				/* */
				.filter(p -> {
					final Map<String, Object> serClass = Casts.as(p.get("class")); // trả về tên class của một object (Array, String)

					return Objects.nonNull(p.get("id"))
							&& Objects.equals(p.get("id"), con.getId()) && Objects.nonNull(serClass);
				})
				/* */
				.findFirst()
				/* */
				.orElseThrow(IllegalArgumentException::new);

//3   Predicate

		final Predicate<ParentObject> isSomething = sv -> list2222.stream().anyMatch(cf -> {

			 final String defaultValue = cf.getName();

			final Integer id = Optional.ofNullable(sv)
					/* */
					.map(ParentObject::getChildObject)
					/* */
					.map(ChildObject::getService)
					/* */
					.map(Service::getId)
					/* */
					.orElse(null);
                    
			return StringUtils.isNotBlank(defaultValue) && Objects.nonNull(id)
					&& StringUtils.equals(defaultValue, Integer.toString(id));
		});
		return list11111.stream().anyMatch(c -> c.getServices().stream().anyMatch(isSomething));

//4   Predicate   compare one value to Object


	final Predicate<ParentObject> isSomething = s -> StringUtils.equals(Optional.ofNullable(s)
				/* */
				.map(ParentObject::getChildObject)
				/* */
				.map(ChildObject::getCode).orElse(null), "1");


// 5  map find and get value 

	Integer	id = parentObjectlists.stream()
				//
				.filter(a -> Objects.equals(a.getId(), "1")
				//
				.findFirst()
				//
				.map(ParentObjectlists::getId)
				//
				.orElse(null);


// 6 complex function - Predicate


final Predicate<ParentObject> isDog = s -> StringUtils.equals(Optional.ofNullable(s)
				/* */
				.map(ParentObject::getChildObject)
				/* */
				.map(ChildObject::getId)
				/* */
				.orElse(null), "1");

final Function<Function<HouseClass, String>, Predicate<HouseObject>> hasType = (f -> c -> {

			final Predicate<ParentObject> isChicken = s -> StringUtils.equals(Optional.ofNullable(s)
					/* */
					.map(ParentObject::getChildObject)
					/* */
					.map(ChildObject::getId)
					/* */
					.map(f)
					/* */
					.orElse(null), "1");
			return c.getId().stream().anyMatch(isDog.and(isChicken));
		});

		final Function<List<Config>, Predicate<HouseObject>> hasTypeCCCCC = (lc -> c -> {
			final Predicate<ParentObject> isSomething = sv -> lc.stream().anyMatch(cf -> {

				final String defaultValue = Objects.isNull(cf) ? "" : cf.getDefaultValue();
				final Integer serviceId = Optional.ofNullable(sv)
						/* */
						.map(ParentObject::getChildObject)
						/* */
						.map(ChildObject::getService)
						/* */
						.map(Service::getServiceId)
						/* */
						.orElse(null);
				return StringUtils.isNotBlank(defaultValue) && Objects.nonNull(serviceId)
						&& StringUtils.equals(defaultValue, Integer.toString(serviceId));
			});
			return c.getServices().stream().anyMatch(isMain.and(isSomething));
		});
		final Supplier<Stream<HouseObject>> racSupplier = () -> Optional.ofNullable(result)
				.map(Reception::getContracts).orElse(Collections.emptyList()).stream();

		final Map<String, Predicate<HouseObject>> xs = new HashMap<>();
		xs.put("a", hasType.apply(HouseClass::getA));
		xs.put("b", hasType.apply(HouseClass::getB));
		if (StringUtils.contains(services, "c")) {
			final List<Config> configs = configDAO.findById(Arrays.asList("aaaaaaaaa"));
			xs.put("c", hasTypeCCCCC.apply(configs));
		}

		return xs.entrySet().stream()
				/* */
				.filter(e -> StringUtils.contains(services, e.getKey()))
				/* */
				.map(e -> new ObjectDtoBuilder(e.getKey(),
						racSupplier.get().filter(e.getValue()).count() > 0 ? "1" : "0").build())
				/* */
				.collect(Collectors.toList());
	}



// 7   tream()  object A then set value for object A
		val.getObject().stream().forEach(x -> {
			x.setName(null);
			x.setAge(obj.getItem(x.getId()));
		});

//================to object=========================
// 1 convert list ObjectA to list objectB with map()
List<Cat> cats = new ArrayList<>();
cats.add(new Cat("name1", 1));
cats.add(new Cat("name2", 2));

final List<Monkey> monkeys = cats.stream().map(p -> {
    Monkey monkey = new Monkey();
    monkey.setAge(p.getAge());
    monkey.setName(p.getName());
    return monkey;
}).collect(Collectors.toList());

// 2 convert list ObjectA to objectB use map()
    final Monkey monkeys = cats.stream().map(p -> {
        Monkey monkey = new Monkey();
        monkey.setAge(p.getAge());
        monkey.setName(p.getName());
        return monkey;
    }).findAny()
    .get();

// 3.convert list ObjectA to list objectB  use forEach()

List<Cat> cats = new ArrayList<>();
cats.add(new Cat("name1", 1));
cats.add(new Cat("name2", 2));
final List<Monkey> monkeys = new ArrayList<>();

 cats.stream().forEach(p -> {
			Monkey monkey = new Monkey();
			monkey.setAge(p.getAge());
			monkey.setName(p.getName());
			monkeys.add(monkey);
		});


//4  convert list ObjectA to list ObjectB use Function

//chuyển hàm bên trong map() thành Function<>

final Function<CatDto, DogDto> toDog = h -> {
			DogDto result = new DogDto();
			result.setName(h.setName());
			result.setAge(h.setAge());
			result.setColor(h.setColor());
			return result;
		};

List<DogDto> dogs = catLists.stream().map(toDog).collect(Collectors.toList());


// 5 convert listObjectA to listObjectB use convert function from()
rcs (DogObj)

final List<DogDto> rct = rcs.stream().map(dog -> {
			dog.setName("111");
			dog.setAge('3w');
			return DogDto.of(dog);
		}).collect(Collectors.toList());


public static DogDto of(final DogObj domain) {
		final DogDto dto = new DogDto();

		dto.setId(domain.getId());
		dto.setName(domain.setName());
		dto.setAge(domain.setAge());

		if (Objects.nonNull(domain.getVenderType())) {
			final CatDto cat = new CatDto();
			cat.setName(domain.getCatName());
			cat.setAge(domain.getCatAge);
			dto.setCat(cat);
		}
		return dto;
	}

//6 convert Object A to Object B use convert function to()


final List<DogDto> dogDtos = dogObjs.stream().map(DogDto::toDto)
				.collect(Collectors.toList());

public static DogDto toDto(final DogObj domain) {
		final DogDto dto = new DogDto();
		if (Objects.nonNull(domain)) {
			dto.setName(domain.getName());
			dto.setId(domain.getId());
		}
		return dto;
	}



//=====================end to obj=======================

//=====================foreach() set Object=======================
//1  foreach() add object to list out of stream();   list to list



final List<ParentObject> parentObjects = new ArrayList<>();
final Cat cat = new Cat();

list.stream().forEach(v -> {
					final ParentObject parent = new ParentObject();
					parent.setAttrId(list.getId());
					parent.setCommonColumns(cat.ofNew());
					parent.setAttrKey(list.getKey());
					parent.setAttributeValue(v.getCode());
					parent.setAttrNum(cat.incrementAndGet());
					parentObjects.add(parent);
				});




//2 set field from tream()
obj.setDog(dogs.stream().findFirst().orElse(new Dog()));



//================================================================================
Method References
2021-12-08


 

Method References là cú pháp viết tắt của biểu thức Lambda để gọi phương thức. Ví dụ, nếu biểu thức Lamda được viết như sau:
str -> System.out.println(str)

Chúng ta có thể viết lại theo cách của Method references như sau:

System.out::println

Java 8 cho phép truyền một tham chiếu của một method hoặc constructor thông qua việc sử dụng từ khóa ::

Trong method reference, ta đặt object (hoặc class) chứa method đó ở trước operator “::” và sau là tên của method không có kèm argument

Cách dùng tham khảo

https://gpcoder.com/3882-phuong-thuc-tham-chieu-trong-java-8-method-references/

https://viblo.asia/p/java-8-method-reference-phan-1-V3m5WObE5O7

Class::staticMethod

obj::minus

object::instanceMethod

String::compareToIgnoreCase);

Class::new

Hello::new;

 class Numbers {
    public static boolean isMoreThanFifty(int n1, int n2) {
      return (n1 + n2) > 50;
    }
    public static List<Integer> findNumbers( List<Integer> l,   BiPredicate<Integer, Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for(Integer i : l) {
          if(p.test(i, i + 10)) {
            newList.add(i);
          }
        }
        return newList;
    }
  }

Ta có thể gọi findNUmbers bằng những cách sau

List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);

 // Using an anonymous class
 findNumbers(list, new BiPredicate<Integer, Integer>() {
   public boolean test(Integer i1, Integer i2) {
     return Numbers.isMoreThanFifty(i1, i2);
   }
 });

 // Using a lambda expression
 findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));

 // Using a method reference
 findNumbers(list, Numbers::isMoreThanFifty);