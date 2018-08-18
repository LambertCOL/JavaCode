package basic.Collection;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/14 15:57
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/14 15:57
 */
public class Human {
    private String name;
    private Character gender;
    private int age;
    private String socialStatus;
    private int power;

    public Human() {
    }

    public Human(String name, Character gender, int age, String socialStatus) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.socialStatus = socialStatus;
        setPower(socialStatus);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    public int getPower() {
        return power;
    }

    private void setPower(String socialStatus) {
        switch (socialStatus.substring(0, 1)) {
            case "国":
                this.power = 6;
                break;
            case "省":
                this.power = 5;
                break;
            case "市":
                this.power = 4;
                break;
            case "区":
                this.power = 3;
                break;
            case "乡":
                this.power = 2;
                break;
            case "镇":
                this.power = 1;
                break;
            case "村":
                this.power = 0;
                break;
        }
    }
}
