/** 
 *  Copyright (c) 2015 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.reveno.atp.api.query;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface QueryManager {

	<V> V find(Class<V> viewType, long id);

	default <V> Optional<V> findO(Class<V> viewType, long id) {
		return Optional.ofNullable(find(viewType, id));
	}
	
	<V> Collection<V> select(Class<V> viewType);
	
	<V> Collection<V> select(Class<V> viewType, Predicate<V> filter);
	
	<V> Collection<V> parallelSelect(Class<V> viewType, Predicate<V> filter);
	
}
