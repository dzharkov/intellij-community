/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intellij.lang.regexp;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

public class RegExpSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
  private final ParserDefinition myParserDefinition;

  public RegExpSyntaxHighlighterFactory() {
    this(RegExpLanguage.INSTANCE);
  }

  protected RegExpSyntaxHighlighterFactory(@NotNull Language language) {
    myParserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language);
  }


  @NotNull
  protected SyntaxHighlighter createHighlighter() {
    return new RegExpHighlighter(null, myParserDefinition);
  }
}
