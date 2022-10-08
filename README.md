# Java_OOP
Library management

***Lớp Book: đóng gói các thông tin về đầu sách trong thư viện, mỗi đối tượng của lớp Book là một đầu sách trong thư viện.

+ Mỗi đầu sách gồm các thông tin: mã đầu sách (bookID), tiêu đề (bookTitle), số lượng các cuốn sách của đầu sách này (amount), số lượng các cuốn sách hiện còn lại trong thư viện (available). Ban đầu thì available = amount, khi có người mượn sách của đầu sách tương ứng thì available giảm đi 1 thể hiện có 1 cuốn sách được mượn. Ngược lại khi trả sách thì available sẽ tăng thêm 1. 

+ Các thuộc tính được thiết kế với giới hạn truy cập private, có các phương thức public get/set cho các thuộc tính này.
+ Lớp Book có hai phương thức khởi tạo: 

Constructor không tham số, khởi tạo giá trị mặc định cho các thuộc tính.
Constructor với 3 tham số cung cấp thông tin chi tiết cho đối tượng đầu sách mới được tạo ra (khi mới tạo thì available = amount). 

+ Phương thức showBookInfo() hiển thị thông tin của cuốn sách ra màn hình như sau: 

Book ID: … 
Book Title: … 
Total Amount: … 
Available: … 

***Lớp Library chứa các thông tin chung về thư viện như: tên thư viện,… và các chức năng xử lý chính:
+ Một thư viện có các thông tin: tên thư viện (libraryName), danh sách các đầu sách của thư viện (mảng bookList: Book[]). Thông tin về số lượng đầu sách hiện có trong thư viện được lưu trong thuộc tính static (numberOfBooks). Do thư viện trong bài toán của chúng ta là một thư viện nhỏ (tủ sách nhỏ) nên số lượng đầu sách có giới hạn, không quá 100. Thông tin giới hạn này được ghi nhận trong một hằng static (MAX_NUMBER_OF_BOOKS), nếu số lượng đầu sách hiện tại đã đến giới hạn thì không thể thêm mới đầu sách vào thư viện. 

+ Phương thức khởi tạo cho lớp Library.

+ Phương thức addNewBook(): phương thức này cho phép người dùng nhập các thông tin mới của một đầu sách từ bàn phím và thêm nó nào danh sách đầu sách của thư viện. Chú ý: trước khi thêm một đầu sách mới cần kiểm tra xem số lượng đầu sách trong thư viện đã quá giới hạn chưa. Và kiểm tra để các bookID không được trùng nhau. 

+ Phương thức findBook(bookID): tìm kiếm thông tin đầu sách trong thư viện, trong bài toán đơn giản này thì sẽ tìm kiếm theo bookID.
        Nếu tìm thấy: 
            Retuns true, In ra thông tin đầu sách tìm thấy.
        Ngược lại: 
            Return false.
Ví dụ khi người dùng chọn chức năng 3 trong menu chương trình: người dùng sẽ được yêu cầu nhập vào BookID cần tìm, giá trị ID truyền vào cho lời gọi findBook để thực hiện tìm kiếm.

+ Phương thức borrowBook(bookID): xử lý mượn sách 
Kiểm tra nếu đầu sách có thể cho mượn (giá trị available>0) không.
Nếu có thể thì thông báo cho mượn thành công và cập nhật số lượng còn lại của đầu sách đó.
Hiển thị lại thông tin sau khi cập nhật. 
Ví dụ khi người dùng chọn chức năng 4 trong menu chương trình: người dùng sẽ được yêu cầu nhập vào BookID để mượn sách, giá trị ID truyền vào cho lời gọi borrowBook để xử lý mượn sách. 
 
+ Phương thức returnBook(bookID): xử lý trả sách 
Cập nhật số lượng còn lại của đầu sách đó.
Hiển thị lại thông tin sau khi cập nhật. 
Ví dụ khi người dùng chọn chức năng 5 trong menu chương trình: người dùng sẽ được yêu cầu nhập vào BookID để trả sách, giá trị ID truyền vào cho lời gọi returnBook để xử lý trả sách. 

+ Phương thức showLibraryInfo() hiển thị thông tin chi tiết của thư viện: tên thư viện, số lượng đầu sách hiện có và danh sách các đầu sách trong thư viện.

+ Phương thức nạp chồng: findBook(String keyword): boolean 
- Tìm kiếm đầu sách theo từ khoá trong tiêu đề.
- Đầu vào của phương thức là xâu ký tự chứa các từ khoá tìm kiếm.
- Thực hiện xử lý tìm kiếm các đầu sách mà tiêu đề có chứa từ khoá tìm kiếm trên 
      Nếu tìm thấy: trả về true, In ra số lượng đầu sách tìm thấy và danh sách đầu sách tương ứng.
      Nếu không tìm thấy, trả về false.
Chú ý: ví dụ keyword tìm kiếm là “Harry Potter” thì các đầu sách chứa một trong hai từ “Harry” hoặc “Potter” hoặc chứa cả hai thì đều thoả mãn. 
(Việc tìm chính xác ký tự hoặc tìm mà không phân biệt ký tự viết hoa, viết thường là sinh viên tuỳ ý lựa chọn 1 trong 2 cách)

+ Phương thức: getALuckyBook(): Book 

- Sắp đến ngày lễ 30/04 – 01/05 bác tổ trưởng quyết định tặng cho mỗi bạn nhỏ đến tủ sách khu phố một quyển sách bất kỳ. Phương thức getALuckyBook() giúp bác tổ trưởng chọn ngẫu nhiên một trong các đầu sách của thư viện để tặng, sau đó cập nhật số lượng còn lại của đầu sách đó. 

***Lớp Program chứa phương thức main() để thực thi chương trình.

+ Thuộc tính option chứa thứ tự chức năng người dùng lựa chọn.
+ Phương thức showMenu() hiển thị menu chính của chương trình.
+ Phương thức askOption() đọc lựa chọn của người dùng và lưu vào option. 
