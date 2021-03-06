/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 MrBlobman
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.mrblobman.nbt.v1_11_R1;

import io.github.mrblobman.nbt.NBTBaseTag;
import io.github.mrblobman.nbt.NBTType;
import net.minecraft.server.v1_11_R1.NBTBase;
import net.minecraft.server.v1_11_R1.NBTTagList;

public class NBTListTag extends io.github.mrblobman.nbt.NBTListTag {
    private NBTTagList nmsTag;

    public NBTListTag() {
        super(new NBTTagList());
        this.nmsTag = (NBTTagList) super.getHandle();
        super.valueType = nmsTag.g();
    }

    public NBTListTag(NBTTagList handle) {
        super(handle);
        this.nmsTag = (NBTTagList) super.getHandle();
        super.valueType = nmsTag.g();
    }

    @Override
    public int size() {
        return nmsTag.size();
    }

    @Override
    protected void addInternal(NBTBaseTag tag) {
        nmsTag.add((NBTBase) tag.getHandle());
    }

    @Override
    protected void setInternal(int pos, NBTBaseTag tag) {
        nmsTag.a(pos, (NBTBase) tag.getHandle());
    }

    @Override
    public NBTBaseTag remove(int pos) {
        NBTBase obj = nmsTag.remove(pos);
        return NBTType.getType(obj.getTypeId()).wrapHandle(obj);
    }

    @Override
    public boolean isEmpty() {
        return nmsTag.isEmpty();
    }

    @Override
    public NBTBaseTag get(int pos) {
        if (pos >= size()) return null;
        NBTBase obj = nmsTag.h(pos);
        return NBTType.getType(obj.getTypeId()).wrapHandle(obj);
    }

    @Override
    public io.github.mrblobman.nbt.NBTListTag get() {
        return this;
    }
}
