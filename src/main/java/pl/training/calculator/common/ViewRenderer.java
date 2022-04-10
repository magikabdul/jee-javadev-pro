package pl.training.calculator.common;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ViewRenderer {

    private static final String VIEW_SUFFIX = "View";

    private final Instance<View> views;
    private Map<String, View> mappings;

    @PostConstruct
    public void init() {
        mappings = views.stream().collect(toMap(this::toViewName, view -> view));
    }

    private String toViewName(View view) {
        var viewName = view.getClass().getSimpleName();
        return viewName.substring(0, viewName.lastIndexOf(VIEW_SUFFIX));
    }

    public void render(@Observes ModelAndView modelAndView) {
        var view = mappings.get(modelAndView.getViewName());
        view.render(modelAndView.getData());
    }

}
