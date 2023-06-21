package javaGame.turnFight;

public class Unit {
    int hp, mp;
    TypeDefence typeDefence;

    Unit(){
        setting();
    }
    void setting(){
        hp = 100;
        mp = 100;
        typeDefence = new TypeDefence(60, 40, 40);
    }

    /* 공격 */

    /* 공격 - 스킬 */
    private class ATypeSkill implements Skill{
        @Override
        public void act(Unit unit) {
            unit.typeDefence.typedValue(Type.A, 50);
        }
    }

    /**
     * 공격 - 스킬 - 실행 메서드
     * @param skill 스킬의 종류
     * @param target 목표 대상
     */
    void skillTriger(Skill skill, Unit target){
        skill.act(target);
    }

    /* 피격 */

    /**
     * 피격 - 실행 메서드
     * @param type 피격 타입
     * @param damage 피해량
     */
    void damage(Type type, int damage){
        hp -= typeDefence.typedValue(type, damage);
    }
}
