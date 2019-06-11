package org.cloudfun.design.pattern.structrue;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ 2019/6/9
 *
 * @author cloudgc
 * @since 0.0.1
 * <p>
 * 树形结构下的通用处理方法
 */
public class CompositePattern {

    static abstract class LegoCarModal {
        private String name;


        public LegoCarModal(String name) {
            this.name = name;
        }

        public String getSlotName() {
            return this.name;
        }

        public abstract String showInfo();
    }


    static class LeafLegoCarModal extends LegoCarModal {

        public LeafLegoCarModal(String name) {
            super(name);
        }

        @Override
        public String showInfo() {
            return "/" + this.getSlotName() + "\n";
        }

    }

    static class SlotLegoCarModal extends LegoCarModal {

        List<LegoCarModal> subSlotLego = new ArrayList<>();

        public SlotLegoCarModal(String name) {
            super(name);
        }

        @Override
        public String showInfo() {
            StringBuilder bf = new StringBuilder();
            for (LegoCarModal carModal : subSlotLego) {
                StringBuilder a = new StringBuilder("/" + this.getSlotName());
                a.append(carModal.showInfo());
                bf.append(a);
//                System.out.println(a.toString());
            }

            return bf.toString();
        }

        public void add(LegoCarModal legoCarModal) {
            this.subSlotLego.add(legoCarModal);
        }

        public List<LegoCarModal> getSubSlotLego() {
            return this.subSlotLego;
        }


    }

    public static void main(String[] args) {
        SlotLegoCarModal carModal1 = new SlotLegoCarModal("core");


        // add body
        SlotLegoCarModal carModal2 = new SlotLegoCarModal("body");
        carModal1.add(carModal2);

        SlotLegoCarModal carModal3 = new SlotLegoCarModal("arm");
        LegoCarModal carModal31 = new LeafLegoCarModal("finger1");
        LegoCarModal carModal32 = new LeafLegoCarModal("finger2");

        carModal2.add(carModal3);

        carModal3.add(carModal31);
        carModal3.add(carModal32);

        //add leg
        SlotLegoCarModal carModal4 = new SlotLegoCarModal("leg");

        LegoCarModal carModal41 = new LeafLegoCarModal("toe1");
        LegoCarModal carModal42 = new LeafLegoCarModal("toe2");

        carModal2.add(carModal4);
        carModal4.add(carModal41);
        carModal4.add(carModal42);

        String s = carModal1.showInfo();

        System.out.println(s);


    }


}
