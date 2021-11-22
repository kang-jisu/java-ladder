package nextstep.refactor_ladder.ui;

import nextstep.ladder.utils.InputUtils;
import nextstep.ladder.utils.Preconditions;
import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Integer MINIMUM_HEIGHT_SIZE = 1;
    private static final Integer MINIMUM_PERSON_SIZE = 2;

    public List<Person> inputPersonName() {
        String personNames = InputUtils.input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        List<Person> people = getPeople(personNames);

        Preconditions.checkMinimumSize(people.size(), MINIMUM_PERSON_SIZE,
                                       String.format("사람 수는 %s 이상 이어야 합니다.", MINIMUM_PERSON_SIZE));
        return people;
    }

    public List<ExecutionResult> inputExecutionResult() {
        String executionResult = InputUtils.input("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return getExecutionResults(executionResult);
    }

    public Integer inputHeightOfLadder() {
        Integer heightOfLadder = InputUtils.inputToInteger("최대 사다리 높이는 몇 개인가요?");

        Preconditions.checkMinimumSize(heightOfLadder, MINIMUM_HEIGHT_SIZE,
                                       String.format("사다리 높이는 %s 이상 이어야 합니다.", MINIMUM_HEIGHT_SIZE));
        return heightOfLadder;
    }

    public Person inputResultOfPerson() {
        String personName = InputUtils.input("결과를 보고 싶은 사람은?");
        Preconditions.checkString(personName, "사람 이름은 필수값입니다.");
        return Person.from(personName);
    }

    private List<Person> getPeople(String personNames) {
        return Arrays.stream(personNames.split(DELIMITER))
                .map(Person::from)
                .collect(Collectors.toList());
    }

    private List<ExecutionResult> getExecutionResults(String executionResult) {
        return Arrays.stream(executionResult.split(DELIMITER))
                .map(ExecutionResult::from)
                .collect(Collectors.toList());
    }
}
