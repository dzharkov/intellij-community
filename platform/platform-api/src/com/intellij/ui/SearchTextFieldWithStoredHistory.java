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

/*
 * @author max
 */
package com.intellij.ui;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;

public class SearchTextFieldWithStoredHistory extends SearchTextField {
  private final String myPropertyName;

  public SearchTextFieldWithStoredHistory(@NonNls final String propertyName) {
    myPropertyName = propertyName;
    reset();
  }

  public void addCurrentTextToHistory() {
    super.addCurrentTextToHistory();
    PropertiesComponent.getInstance().setValue(myPropertyName, StringUtil.join(getHistory(), "\n"));
  }

  public void reset() {
    final PropertiesComponent propertiesComponent = PropertiesComponent.getInstance();
    final String history = propertiesComponent.getValue(myPropertyName);
    if (history != null) {
      final String[] items = history.split("\n");
      ArrayList<String> result = new ArrayList<String>();
      for (String item : items) {
        if (item != null && item.length() > 0) {
          result.add(item);
        }
      }
      setHistory(result);
    }
    setSelectedItem("");
  }
}