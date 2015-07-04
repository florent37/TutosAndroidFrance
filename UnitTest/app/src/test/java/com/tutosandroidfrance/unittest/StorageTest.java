package com.tutosandroidfrance.unittest;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by florentchampigny on 03/07/15.
 */
public class StorageTest {

    @Mock Context context;
    @Mock SharedPreferences sharedPreferences;
    @Mock SharedPreferences.Editor editor;

    //l'objet à tester
    Storage storage;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); //créé tous les @Mock

        //on remplace le context.getSharedPreferences(String,int) afin qu'il retourne notre mock sharedPreferences
        doReturn(sharedPreferences).when(context).getSharedPreferences(anyString(), anyInt());

        //on remplace le sharedPreferences.edit() afin qu'il retourne notre mock edit
        doReturn(editor).when(sharedPreferences).edit();

        //on remplace la fonction edit.putString(String, String) afin qu'elle retourne edit,
        //afin d'éviter le crash au edit.putString(S,S).apply
        doReturn(editor).when(editor).putString(anyString(), anyString());

        //puis on constrit notre storage avec notre mock context
        storage = new Storage(context);
    }

    @Test
    public void testTransformToString() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        String string = storage.transformToString(integers);

        assertEquals("1,2,3",string);
    }

    @Test
    public void testTransformFromString() throws Exception {
        String string = "1,2,3";

        List<Integer> integers = storage.transformFromString(string);

        assertEquals(Arrays.asList(1, 2, 3),integers);
    }

    @Test
    public void testLoad() throws Exception {
        doReturn("1,2,3").when(sharedPreferences).getString(anyString(),isNull(String.class));

        List<Integer> integers = storage.load();

        verify(sharedPreferences, atLeastOnce()).getString(anyString(),isNull(String.class));
        assertEquals(Arrays.asList(1, 2, 3), integers);
    }

    @Test
    public void testLoadNull() throws Exception {
        doReturn(null).when(sharedPreferences).getString(anyString(),isNull(String.class));

        List<Integer> integers = storage.load();

        verify(sharedPreferences, atLeastOnce()).getString(anyString(),isNull(String.class));
        assertTrue(integers.isEmpty());
    }

    @Test
    public void testSave() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        storage.save(integers);

        verify(editor, atLeastOnce()).putString(anyString(),eq("1,2,3"));
        verify(editor, atLeastOnce()).apply();
    }

}