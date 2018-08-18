package basic.Collection;

import java.util.Comparator;

/**
 * @ProjectName: JavaCode
 * @Package: basic.Collection
 * @Description:
 * @Author: 劳元源
 * @CreateDate: 2018/8/14 15:54
 * @UpdateUser: 劳元源
 * @UpdateDate: 2018/8/14 15:54
 */
public class comparator4collection implements Comparator<Human> {
    public static void main(String[] args) {
        Human h1 = new Human("我是省长", 'M', 48, "省长");
        Human h2 = new Human("我是镇长", 'M', 52, "镇长");
        Human h3 = new Human("我是省长", 'F', 52, "省长");
        int i = compareHuman(h1, h2);
        System.out.println((i > 0 ? h1.getName()+h1.getAge() : h2.getName()+h2.getAge()) + "官衔大");
        i = compareHuman(h1, h3);
        System.out.println((i > 0 ? h1.getName()+h1.getAge() : h3.getName()+h3.getAge()) + "官衔大");
        i = compareHuman(h3, h2);
        System.out.println((i > 0 ? h3.getName()+h3.getAge() : h2.getName()+h2.getAge()) + "官衔大");
    }

    private static int compareHuman(Human h1, Human h2) {
        return new comparator4collection().compare(h1, h2);
    }

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getPower() > o2.getPower()) {//权力相比
            return 1;
        } else if (o1.getPower() < o2.getPower()) {
            return -1;
        } else {//权力相同比年龄
            if (o1.getAge() > o2.getAge()) {//年龄相比
                return 1;
            } else if (o1.getPower() < o2.getPower()) {
                return -1;
            } else return 0;
        }
    }
}
