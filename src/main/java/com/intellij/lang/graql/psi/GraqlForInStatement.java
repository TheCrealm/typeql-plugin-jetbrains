// This is a generated file. Not intended for manual editing.
package com.intellij.lang.graql.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GraqlForInStatement extends PsiElement {

  @NotNull
  GraqlBlock getBlock();

  @NotNull
  GraqlEscapedExpression getEscapedExpression();

  @NotNull
  GraqlIdentifier getIdentifier();

}