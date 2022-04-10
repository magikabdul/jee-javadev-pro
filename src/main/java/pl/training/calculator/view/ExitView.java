package pl.training.calculator.view;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.common.View;

import java.util.Map;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ExitView implements View {

    @Override
    public void render(Map<String, Object> data) {
    }

}
