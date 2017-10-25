package test.bwie.com.yuekao.bean;

import java.util.List;

/**
 * Created by dell on 2017/10/25.
 */

public class Bean1 {

    /**
     * date : 20171025
     * stories : [{"images":["https://pic1.zhimg.com/v2-08f97fddae1aa35993d4dfb14ea31054.jpg"],"type":0,"id":9653750,"ga_prefix":"102518","title":"为什么很多女生会喜欢听甜言蜜语？"},{"images":["https://pic1.zhimg.com/v2-b4747aa8b8e4f5d9af2115430862b9f0.jpg"],"type":0,"id":9653557,"ga_prefix":"102517","title":"郭襄寻不到杨过出家为尼，为何不回到家人身边抵抗敌人同生共死？"},{"images":["https://pic2.zhimg.com/v2-4f639930a1cf7e6e2f530343cfacb439.jpg"],"type":0,"id":9653800,"ga_prefix":"102516","title":"你想当一个活着的怪物，还是做一个死去的好人？"},{"images":["https://pic2.zhimg.com/v2-3af4452834bd47d965de04e32b056fe9.jpg"],"type":0,"id":9653394,"ga_prefix":"102515","title":"如今「坏人」已经可以列出 18 种，他们擅长的东西你都不要信"},{"images":["https://pic3.zhimg.com/v2-7b58d1a1a38b6302d76d2698b0a08d8a.jpg"],"type":0,"id":9653576,"ga_prefix":"102514","title":"把树抱住后使劲摇摇摇\u2026\u2026你看人家这摘果子的方法清奇的"},{"images":["https://pic1.zhimg.com/v2-714718adf58cc1a111c422d2514e2354.jpg"],"type":0,"id":9653776,"ga_prefix":"102513","title":"记住这些知识点，去日本迷失在车站里也能会心一笑"},{"images":["https://pic2.zhimg.com/v2-36c115eaf6a006719f71a94cd2993f59.jpg"],"type":0,"id":9653346,"ga_prefix":"102512","title":"大误 · 让地球从内到外冷下来"},{"images":["https://pic3.zhimg.com/v2-c98d605967a61c53abd811e683e62dde.jpg"],"type":0,"id":9653785,"ga_prefix":"102511","title":"歌手是怎么创作歌曲的？"},{"images":["https://pic3.zhimg.com/v2-ed8af5cd65b6bca6c9b4966b05e1b72a.jpg"],"type":0,"id":9653414,"ga_prefix":"102510","title":"虽说「人心狠毒」，为什么很少见到真正有毒的哺乳动物？"},{"images":["https://pic4.zhimg.com/v2-c48d2c752ec7b8b183055667b76596c7.jpg"],"type":0,"id":9653540,"ga_prefix":"102509","title":"没和身边人一起进大律所，可后来，我却学得比他们多"},{"images":["https://pic3.zhimg.com/v2-8d3803d6014153f1aa9835b47ccd7db2.jpg"],"type":0,"id":9653658,"ga_prefix":"102508","title":"没有「爆裂脑花」、细思 bug 极多\u2026\u2026唯一的亮点只剩特工代号"},{"images":["https://pic3.zhimg.com/v2-8569d560d951c65cc1c712b8976c8fba.jpg"],"type":0,"id":9653620,"ga_prefix":"102507","title":"身为杂食性动物的两脚兽，我们要吃蔬菜水果，喵汪星人呢？"},{"images":["https://pic2.zhimg.com/v2-340313b0e29d374f9a7fbe3cb45483e1.jpg"],"type":0,"id":9653718,"ga_prefix":"102507","title":"姚老板的球队能卖多少钱，起决定作用的是他另一个身份"},{"images":["https://pic3.zhimg.com/v2-d839d13157eb525ed60c34e39fee4d1a.jpg"],"type":0,"id":9653251,"ga_prefix":"102507","title":"《天才枪手》式的造富神话：非典型批片、中国采购团和弯道超车梦"},{"images":["https://pic1.zhimg.com/v2-ea05acac99ff29b8d1b60de506dbcfe4.jpg"],"type":0,"id":9653582,"ga_prefix":"102506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-20786b64172211a00c6e611b1bfbb2b6.jpg","type":0,"id":9653557,"ga_prefix":"102517","title":"郭襄寻不到杨过出家为尼，为何不回到家人身边抵抗敌人同生共死？"},{"image":"https://pic4.zhimg.com/v2-97d9c4d8c3c673b10772682e5ac0c137.jpg","type":0,"id":9653785,"ga_prefix":"102511","title":"歌手是怎么创作歌曲的？"},{"image":"https://pic2.zhimg.com/v2-e7582788c34b9d40b7b849ea3458d0dd.jpg","type":0,"id":9653718,"ga_prefix":"102507","title":"姚老板的球队能卖多少钱，起决定作用的是他另一个身份"},{"image":"https://pic1.zhimg.com/v2-e5b5e2342378517d1ddeb3f26496367c.jpg","type":0,"id":9653251,"ga_prefix":"102507","title":"《天才枪手》式的造富神话：非典型批片、中国采购团和弯道超车梦"},{"image":"https://pic2.zhimg.com/v2-2f8827e1dd120aecea73713fd27f67d1.jpg","type":0,"id":9653576,"ga_prefix":"102514","title":"把树抱住后使劲摇摇摇\u2026\u2026你看人家这摘果子的方法清奇的"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-08f97fddae1aa35993d4dfb14ea31054.jpg"]
         * type : 0
         * id : 9653750
         * ga_prefix : 102518
         * title : 为什么很多女生会喜欢听甜言蜜语？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-20786b64172211a00c6e611b1bfbb2b6.jpg
         * type : 0
         * id : 9653557
         * ga_prefix : 102517
         * title : 郭襄寻不到杨过出家为尼，为何不回到家人身边抵抗敌人同生共死？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


    }
}
