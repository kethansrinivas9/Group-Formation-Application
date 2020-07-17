package com.group8.dalsmartteamwork.groupformationlogic.models;

public class ComparatorFactory implements IComparatorFactory {

    @Override
    public IComparator getComparator(int typeID) {
        if (typeID == QuestionType.NUMERIC.getValue()) {
            return new NumericComparator();
        } else if (typeID == QuestionType.MULTIPLE_CHOICE_SINGLE_OPTION.getValue()) {
            return new MultipleChoiceSingleComparator();
        } else if (typeID == QuestionType.MULTIPLE_CHOICE_MULTIPLE_OPTION.getValue()) {
            return new MultipleChoiceMultiComparator();
        } else {
            return new FreeTextComparator();
        }
    }
}
