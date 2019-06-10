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

    static class LegoCarModal {
        public LegoCarModal(String number) {
            this.number = number;
        }

        String number;

        List<LegoCarModal> slot;
    }

    static abstract class AbstractCarModal {

        public AbstractCarModal(LegoCarModal modal){

        }
        abstract void slot(LegoCarModal modal);
    }

    static class CarModal extends  AbstractCarModal{

        private LegoCarModal carModal;

        public CarModal(LegoCarModal modal) {
            super(modal);
            this.carModal=modal;
            if(carModal.slot==null){
                carModal.slot=new ArrayList<>();
            }
        }

        @Override
        void slot(LegoCarModal modal) {
            carModal.slot.add(modal);
        }
    }


    public static void main(String[] args) {

        LegoCarModal coreModal=new LegoCarModal("core");

        CarModal carModal=new CarModal(coreModal);

//        carModal.slot();





    }


}
