package com.example.mycity.data

// Recommendations Data Provider
object DataProvider {
    private val recommendations = mapOf(
        "Hà Nội" to listOf(
            Recommendation(
                id = 1,
                title = "Hồ Hoàn Kiếm",
                description = "Hồ Hoàn Kiếm không chỉ là trái tim của Hà Nội mà còn là một điểm đến mang đậm dấu ấn lịch sử và văn hóa. Mặt hồ phẳng lặng, in bóng Tháp Rùa cổ kính tạo nên một khung cảnh thơ mộng giữa lòng thành phố nhộn nhịp. Điểm nhấn của khu vực này còn có cầu Thê Húc rực rỡ sắc đỏ dẫn vào đền Ngọc Sơn – nơi thờ thần Văn Xương Đế Quân và danh tướng Trần Hưng Đạo. Kề bên là khu phố cổ, nơi du khách có thể tản bộ qua 36 phố phường, tận hưởng không khí hoài cổ và khám phá những món ăn đặc sản như phở bò, bún chả, bánh cuốn."
            ),
            Recommendation(
                id = 2,
                title = "Văn Miếu - Quốc Tử Giám",
                description = "Văn Miếu - Quốc Tử Giám, trường đại học đầu tiên của Việt Nam, được biết đến là biểu tượng của truyền thống hiếu học. Khu di tích mang đậm dấu ấn lịch sử với những tấm bia tiến sĩ khắc tên những người đỗ đạt thời xưa, Khuê Văn Các với lối kiến trúc đặc sắc và hồ Văn tạo không gian yên bình giữa lòng thủ đô. Đây là địa điểm lý tưởng để tìm hiểu về văn hóa, giáo dục và lưu giữ những bức ảnh kỷ niệm đậm chất cổ kính."
            ),
            Recommendation(
                id = 3,
                title = "Hoàng thành Thăng Long",
                description = "Hoàng thành Thăng Long Hà Nội một trong những di tích lịch sử quan trọng bậc nhất, nơi lưu giữ dấu ấn của hơn 1.000 năm văn hiến. Từng là trung tâm quyền lực của các triều đại phong kiến, khu di tích này nổi bật với Bắc Môn, Đoan Môn, điện Kính Thiên và cột cờ Hà Nội – biểu tượng kiêu hãnh của thủ đô. Không chỉ mang giá trị lịch sử, Hoàng thành còn là điểm đến lý tưởng để tìm hiểu về kiến trúc và đời sống hoàng cung xưa."
            ),
            Recommendation(
                id = 4,
                title = "Nhà thờ Lớn Hà Nội",
                description = "Tọa lạc giữa lòng phố cổ, nhà thờ Lớn Hà Nội mang đậm dấu ấn kiến trúc Gothic với những mái vòm cao vút và cửa sổ kính màu rực rỡ. Được xây dựng từ cuối thế kỷ XIX, công trình này là một trong những nhà thờ cổ kính nhất của Hà Nội, thường xuyên diễn ra các nghi lễ quan trọng. Không chỉ là nơi hành lễ tôn giáo, khu vực quanh nhà thờ còn là điểm hẹn quen thuộc của giới trẻ với những quán cà phê vỉa hè và không gian mang đậm nét châu Âu cổ kính."
            )
        ),
        "Hồ Chí Minh" to listOf(
            Recommendation(
                id = 5,
                title = "Dinh Độc Lập",
                description = "Dinh Độc Lập, còn gọi là Hội trường Thống Nhất, là công trình lịch sử gắn liền với sự kiện giải phóng miền Nam 30/4/1975. Với kiến trúc hiện đại pha lẫn truyền thống Á Đông, Dinh Độc Lập vừa là điểm tham quan vừa là nơi lưu giữ nhiều hiện vật, hình ảnh quan trọng của lịch sử Việt Nam."
            ),
            Recommendation(
                id = 6,
                title = "Nhà thờ Đức Bà",
                description = "Nhà thờ Đức Bà Sài Gòn, được xây dựng từ cuối thế kỷ XIX, là công trình kiến trúc kiểu Roman và Gothic đặc sắc. Với hai tháp chuông cao gần 60m và những bức tường gạch đỏ nguyên bản từ Marseille, nơi đây trở thành biểu tượng tôn giáo và văn hóa của thành phố."
            ),
            Recommendation(
                id = 7,
                title = "Bưu điện Trung tâm Sài Gòn",
                description = "Bưu điện Trung tâm Sài Gòn, nằm đối diện Nhà thờ Đức Bà, là một kiệt tác kiến trúc do Gustave Eiffel thiết kế. Công trình mang đậm phong cách châu Âu kết hợp Á Đông, nổi bật với mái vòm, cửa sổ kính và những họa tiết trang trí tinh xảo. Đây vừa là nơi tham quan vừa là bưu điện hoạt động."
            ),
            Recommendation(
                id = 8,
                title = "Chợ Bến Thành",
                description = "Chợ Bến Thành là một trong những biểu tượng nổi tiếng nhất của TP. Hồ Chí Minh, được xây dựng từ đầu thế kỷ XX. Nơi đây bày bán đa dạng hàng hóa từ thực phẩm, thủ công mỹ nghệ đến quần áo, quà lưu niệm. Đây cũng là địa điểm lý tưởng để trải nghiệm ẩm thực đặc trưng miền Nam."
            )
        )
    )

    fun getCategories(): List<String> = recommendations.keys.toList()

    fun getRecommendations(category: String): List<Recommendation> {
        return recommendations[category] ?: emptyList()
    }
}