/*
 * Copyright (c) 2016, 2019 Gluon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.attach.settings;

import com.gluonhq.attach.util.Services;

import java.util.Optional;

/**
 * The SettingService provides a simple way for storing, retrieving and removing
 * key-value pairs of strings.
 *
 * <p><b>Example</b></p>
 * <pre>
 * {@code Services.get(SettingsService.class).ifPresent(service -> {
 *      service.store("key", "value");
 *      String value = service.retrieve("key");
 *      service.remove("key");
 *  });}</pre>
 *
 * <p><b>Android Configuration</b>: none</p>
 * <p><b>iOS Configuration</b>: none</p>
 *
 * @since 3.0.0
 */
public interface SettingsService {

    /**
     * Returns an instance of {@link SettingsService}.
     * @return An instance of {@link SettingsService}.
     */
    static Optional<SettingsService> create() {
        return Services.get(SettingsService.class);
    }

    /**
     * Stores the setting with the specified key and value. If a setting with
     * the specified key exists, the value for that setting will be overwritten
     * with the specified value.
     *
     * @param key a key that uniquely identifies the setting
     * @param value the value associated with the key
     */
    void store(String key, String value);

    /**
     * Removes the setting for the specified key.
     *
     * @param key the key of the setting that needs to be removed
     */
    void remove(String key);

    /**
     * Retrieves the value of the setting that is identified by the specified
     * key.
     *
     * @param key the key of the setting to look up
     * @return the value associated with the setting or <code>null</code> when
     * no setting was stored with the specified key
     */
    String retrieve(String key);

}
