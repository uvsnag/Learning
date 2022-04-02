1. final

// được sử dụng để hạn chế người dùng. Từ khóa final có thể được sử dụng trong nhiều ngữ cảnh:

// -Biến final: bạn không thể thay đổi giá trị của biến final (nó sẽ là hằng số).
// -Phương thức final: bạn không thể ghi đè phương thức final.
// -Lớp final: bạn không thể kế thừa lớp final.
// -Biến static final trống: Một biến final mà không được khởi tạo tại thời điểm khai báo được gọi là biến final trống.
// Từ khóa final có thể được áp dụng với các biến, một biến final mà không có giá trị nào được gọi là biến final trống hoặc biến final không được khởi tạo.
//  Nó chỉ có thể được khởi tạo trong Constructor. Biến final trống cũng có thể là static mà sẽ chỉ được khởi tạo trong khối static.

2. TRONG JAVA LIST KHÁC SET Ở ĐIỂM NÀO?

// Cả List interface và Set interface đều kế thừa Collections Framework. Tuy nhiên, có một số khác biệt giữa chúng.
// -List có thể chứa các phần tử trùng lặp. Tuy nhiên, Set là không thể chứa các phần tử trùng lặp.
// -Các phần tử trong List được lưu trữ theo thứ tự. Tuy nhiên, các phần tử trong Set được lưu trữ trong các nhóm như tập hợp trong toán học.

3. static
// Biến static có thể được sử dụng để tham chiếu thuộc tính chung của tất cả đối tượng (mà không là duy nhất cho mỗi đối tượng), ví dụ như tên công ty của nhân viên, tên trường học của các sinh viên, …
// Biến static lấy bộ nhớ chỉ một lần trong Class Area tại thời gian tải lớp đó.

4. Immutable object (String, Integer..)
// Một immutable object là một đối tượng có trạng thái bên trong không đổi sau khi được khởi tạo. Điều này có nghĩa là một khi object đã được gán cho một biến, 
// chúng ta sẽ không thể cập nhật giá trị của object này thông qua các biến tham chiếu.