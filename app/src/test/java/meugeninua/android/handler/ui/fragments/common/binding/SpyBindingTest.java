package meugeninua.android.handler.ui.fragments.common.binding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import meugeninua.android.handler.utils.tests.AnnotatedTest;

public class SpyBindingTest extends AnnotatedTest {

    private static final int VIEW_ID = 1;

    @Spy
    private Binding binding;

    @Test
    public void bindingGet_foundValidView_gotSameView() {
        // given
        View view = Mockito.mock(View.class);
        Mockito.doReturn(view).when(binding).find(VIEW_ID);

        // when
        View foundView = binding.get(VIEW_ID);

        // then
        Assert.assertEquals(view, foundView);
    }

    @Test(expected = NullPointerException.class)
    public void bindingGet_viewNotFound_exceptionThrown() {
        // given
        Mockito.doReturn(null).when(binding).find(VIEW_ID);

        // when
        binding.get(VIEW_ID);

        // then
        Assert.fail("Should not be here, since view is not found");
    }

    @Test
    public void bindingHas_foundValidView_trueReturned() {
        // given
        View view = Mockito.mock(View.class);
        Mockito.doReturn(view).when(binding).find(VIEW_ID);

        // when
        boolean value = binding.has(VIEW_ID);

        // then
        Assert.assertTrue(value);
    }

    @Test
    public void bindingHas_viewNotFound_falseReturned() {
        // given
        Mockito.doReturn(null).when(binding).find(VIEW_ID);

        // when
        boolean value = binding.has(VIEW_ID);

        // then
        Assert.assertFalse(value);
    }

    @Test
    public void bindingSetOnClickListener_foundValidView_setOnClickListenerCalled() {
        // given
        View view = Mockito.mock(View.class);
        Mockito.doReturn(view).when(binding).get(VIEW_ID);

        // when
        View.OnClickListener listener = Mockito.mock(View.OnClickListener.class);
        binding.setOnClickListener(VIEW_ID, listener);

        // then
        Mockito.verify(view).setOnClickListener(listener);
    }

    @Test
    public void bindingSetTextRes_foundValidView_setTextCalled() {
        // given
        TextView textView = Mockito.mock(TextView.class);
        Mockito.doReturn(textView).when(binding).get(VIEW_ID);

        // when
        int textId = 2;
        binding.setText(VIEW_ID, textId);

        // then
        Mockito.verify(textView).setText(textId);
    }

    @Test(expected = ClassCastException.class)
    public void bindingSetTextRes_foundInvalidView_exceptionThrown() {
        // given
        Mockito.doReturn(Mockito.mock(ImageView.class)).when(binding).get(VIEW_ID);

        // when
        binding.setText(VIEW_ID, 2);

        // then
        Assert.fail("Should not be here, since found invalid view");
    }

    @Test
    public void bindingSetText_foundValidView_setTextCalled() {
        // given
        TextView textView = Mockito.mock(TextView.class);
        Mockito.doReturn(textView).when(binding).get(VIEW_ID);

        // when
        CharSequence text = Mockito.mock(CharSequence.class);
        binding.setText(VIEW_ID, text);

        // then
        Mockito.verify(textView).setText(text);
    }

    @Test(expected = ClassCastException.class)
    public void bindingSetText_foundInvalidView_exceptionThrown() {
        // given
        Mockito.doReturn(Mockito.mock(ImageView.class)).when(binding).get(VIEW_ID);

        // when
        binding.setText(VIEW_ID, Mockito.mock(CharSequence.class));

        // then
        Assert.fail("Should not be here, since found invalid view");
    }
}
