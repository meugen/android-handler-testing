package meugeninua.android.handler.ui.fragments.common.binding;

import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import meugeninua.android.handler.utils.tests.AnnotatedTest;

public class BindingTest extends AnnotatedTest {

    @Mock
    private View view;
    private Binding binding;

    @Before
    public void setUp() {
        binding = new Binding(view);
    }

    @Test
    public void viewBinding_callGet_findViewByIdCalled() {
        // given
        int viewId = 1;
        View foundView = Mockito.mock(View.class);
        Mockito.when(view.findViewById(viewId)).thenReturn(foundView);

        // when
        View resultView = binding.get(viewId);

        // then
        Assert.assertEquals(resultView, foundView);
    }

    @Test
    public void viewBinding_callGetTwice_findViewByIdCalledOnce() {
        // given
        int viewId = 1;
        Mockito.when(view.findViewById(viewId))
            .thenReturn(Mockito.mock(View.class));

        // when
        binding.get(viewId);
        binding.get(viewId);

        // then
        Mockito.verify(view, Mockito.times(1))
            .findViewById(viewId);
    }
}
