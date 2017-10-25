package test.bwie.com.yekao;

/**
 * 作者: 赵虔
 * 时间: 2017/9/21
 * 类作用:
 */

public class Bean {
    private String price;
    private String number;

    public Bean(String price, String number) {
        this.price = price;
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
