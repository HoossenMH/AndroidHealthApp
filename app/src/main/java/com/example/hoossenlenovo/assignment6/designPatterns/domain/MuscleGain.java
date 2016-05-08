package com.example.hoossenlenovo.assignment6.designPatterns.domain;

import com.example.hoossenlenovo.assignment6.domain.Exercise;

import java.io.Serializable;

/**
 * Created by Toshiba on 2016/04/07.
 */
public class MuscleGain extends Exercise implements Serializable {

    private Long id;
    private int chestsAmount;
    private int benchPressAmount;
    private int inclineBenchPressAmount;

    private static final long serialVersionUID = 1L;

    public MuscleGain() {
    }

    public MuscleGain(Long id,int chestsAmount, int benchPressAmount, int inclineBenchPressAmount) {
        this.id = id;
        this.chestsAmount = chestsAmount;
        this.benchPressAmount = benchPressAmount;
        this.inclineBenchPressAmount = inclineBenchPressAmount;
    }

    public Long getId() {
        return id;
    }
    public int getBenchPressAmount() {
        return benchPressAmount;
    }
    public int getChestsAmount() {
        return chestsAmount;
    }
    public int getInclineBenchPressAmount() {
        return inclineBenchPressAmount;
    }

    @Override
    public String exerciseDone()
    {
        return "is done";
    }


    public MuscleGain(Builder builder)
    {
        this.id = builder.id;
        this.chestsAmount = builder.chestsAmount;
        this.benchPressAmount = builder.benchPressAmount;
        this.inclineBenchPressAmount = builder.inclineBenchPressAmount;
    }

    public static class Builder
    {
        private long id;
        private int chestsAmount;
        private int benchPressAmount;
        private int inclineBenchPressAmount;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder chestsAmount(int value){
            this.chestsAmount = value;
            return this;
        }
        public Builder benchPressAmount(int value){
            this.benchPressAmount = value;
            return this;
        }
        public Builder inclineBenchPressAmount(int value){
            this.inclineBenchPressAmount = value;
            return this;
        }

        public Builder copy(MuscleGain value) {
            this.id = value.id;
            this.chestsAmount = value.chestsAmount;
            this.benchPressAmount = value.benchPressAmount;
            this.inclineBenchPressAmount = value.inclineBenchPressAmount;
            return this;
        }

        public MuscleGain build() {
            return new MuscleGain(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MuscleGain)) return false;

        MuscleGain that = (MuscleGain) o;

        if (getChestsAmount() != that.getChestsAmount()) return false;
        if (getBenchPressAmount() != that.getBenchPressAmount()) return false;
        if (getInclineBenchPressAmount() != that.getInclineBenchPressAmount()) return false;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getChestsAmount();
        result = 31 * result + getBenchPressAmount();
        result = 31 * result + getInclineBenchPressAmount();
        return result;
    }
}
