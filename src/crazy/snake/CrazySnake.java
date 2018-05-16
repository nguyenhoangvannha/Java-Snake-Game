/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Viết chương trình "Rắn săn mồi" với các đặc tả sau
//  1 Phải có 1 máy đóng vai trò là server, server luôn ở trạng thái running đợi client (người chơi) kết nối vào.
//  2 Ở máy client, cho phép thay đổi IP của máy server.
//  3 Người chơi kết nối vào game.
//  4 Người chơi xem danh sách những người chơi đang kết nối.
//  5 Người chơi tạo 1 room, server phát sinh 1 code 4 chữ số. Room khi đó sẽ có 1 người, là người tạo room.
//  6 Những người chơi khác có thể join vào join room và nhập code này. Người chơi tự thông báo code cho nhau, không cần hệ thống hỗ trợ.
//  7 Người chủ room được phép start game. Hệ thống phải đếm ngược từ 10 về 1 để các người chơi trong room chuẩn bị.
//  8 Người chơi có thể leave game. Khi người chủ leave game, người join vào đầu tiên (sau người chủ) sẽ là chủ room mới. Nếu room có 1 người và người đó leave game thì coi như room bị xóa, những người khác join vào không được.
//  9 Không thể join vào room nếu room đó đang chơi hoặc đã chơi xong.
//  10 Hỗ trợ nhiều người chơi (tối đa 4 người).
//  11 Mỗi người chơi điều khiển một con rắn.
//  12 Cho phép điều chỉnh bản đồ (vị trí mồi)
//  13 Rắn tăng trưởng kích thước khi ăn mồi
//  14 Đầu rắn chạm vào thân của rắn khác (hoặc thân của nó) sẽ chết
//  15 Người chơi điều khiển rắn tồn tại đến cuối cùng sẽ thắng.
//  16 Hiển thị kết quả. Có thể chọn Play Again để 4 người bắt đầu game mới.
//
//Lưu ý:
//  - Cho phép làm nhóm (tối đa 2 sinh viên)
//  - Sinh viên copy bài của nhau sẽ bị 0 điểm môn học.
//
//Hạn nộp:
//  - 03/06/2018
//  - Nội dung nộp: MSSV1-MSSV2.zip (MSSV1 nộp)
//	+ File jar thực thi
//	+ File ant đóng gói chương trình
//	+ Source code
//	+ Báo cáo
//		+ Cách thực hiện chương trình (3 trang)
//		+ Các chức năng đạt được và Hướng dẫn sử dụng.
//    + Đánh giá các chức năng 1-15, mỗi chức năng có 3 mức điểm: 0 (ko làm), 1 (làm được khoảng 1/2, còn exceptional flow chưa xử lí), 2 (chức năng hoạt động với tất cả các flow).
//		+ Công việc cụ thể của từng người trong nhóm. % đóng góp của từng người (tổng % của các thành viên cộng lại là 100%)
package crazy.snake;

import crazy.snake.view.MainActivity;

/**
 *
 * @author naco
 */
public class CrazySnake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Start CrazySnake");
        MainActivity mainActivity = new MainActivity();
        mainActivity.setVisible(true);
    }
    
}
