/*  
 * Copyright IBM Corp. 2018
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

import java.io.File

println "verifying that downloade bundle layout is correct"

def projectDir = bldDir + "/it/download-layout"
def outFiles = [
        "target/classes/lang_suffix/Strings_fr.json",
        "target/classes/lang_suffix/Strings_zh_Hans.json",
        "target/classes/lang_only/fr.json",
        "target/classes/lang_only/zh_Hans.json",
        "target/classes/lang_dir/fr/Strings.json",
        "target/classes/lang_dir/zh_Hans/Strings.json",
        "target/classes/lang_subdir/fr/Strings.json",
        "target/classes/lang_subdir/zh_hans/Strings.json",
        "target/classes/mapper/res/translated/fr_resource.json",
        "target/classes/mapper/res/translated/zh-Hans_resource.json"
    ]

def missing = []
for (outFile in outFiles) {
    def filePath = projectDir + "/" + outFile;
    def file = new File(projectDir + "/" + outFile)
    if (file.exists()) {
        println "Output file found: " + filePath;
    } else {
        println "Missing: " + filePath;
        missing.add(filePath)
    }
}

if (missing.size() > 0) {
    println "Missing files: " + missing;
    assert false;
}

return true

