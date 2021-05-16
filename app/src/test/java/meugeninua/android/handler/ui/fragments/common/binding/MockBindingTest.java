package meugeninua.android.handler.ui.fragments.common.binding;

import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import meugeninua.android.handler.utils.tests.AnnotatedTest;

public class MockBindingTest extends AnnotatedTest {

    private static final int VIEW_ID = 1;

    @Mock
    private View view;
    private Binding binding;

    @Before
    public void setUp() {
        binding = new Binding(view);
    }

    @Test
    public void callFind_findViewByIdCalled() {
        // given
        View foundView = Mockito.mock(View.class);
        Mockito.doReturn(foundView).when(view).findViewById(VIEW_ID);

        // when
        View resultView = binding.find(VIEW_ID);

        // then
        Assert.assertEquals(resultView, foundView);
    }

    @Test
    public void callFindTwice_findViewByIdCalledOnce() {
        // given
        Mockito.doReturn(Mockito.mock(View.class))
            .when(view).findViewById(VIEW_ID);

        // when
        binding.find(VIEW_ID);
        binding.find(VIEW_ID);

        // then
        Mockito.verify(view, Mockito.times(1))
            .findViewById(VIEW_ID);
    }

    @Test
    public void callFindTwice_returnedTheSameView() {
        // given
        Mockito.doReturn(Mockito.mock(View.class)).when(view).findViewById(VIEW_ID);

        // when
        View result1 = binding.find(VIEW_ID);
        View result2 = binding.find(VIEW_ID);

        // then
        Assert.assertEquals(result1, result2);
    }
}
