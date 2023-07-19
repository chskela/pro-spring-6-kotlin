/*
Freeware License, some rights reserved

Copyright (c) 2023 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy
of this software and associated documentation files (the "Software"),
to work with the Software within the limits of freeware distribution and fair use.
This includes the rights to use, copy, and modify the Software for personal use.
Users are also allowed and encouraged to submit corrections and modifications
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for
commercial use in any way, or for a user's educational materials such as books
or blog articles without prior permission from the copyright holder.

The above copyright notice and this permission notice need to be included
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/
package com.apress.prospring6.seven.crud.entities

import jakarta.persistence.*
import java.io.Serial
import java.time.LocalDate

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@Entity
@Table(name = "ALBUM")
class Album : AbstractEntity() {
	@Column
	var title: String? = null

	@Column(name = "RELEASE_DATE")
	var releaseDate: LocalDate? = null

	@ManyToOne
	@JoinColumn(name = "SINGER_ID")
	var singer: Singer? = null

	override fun toString(): String {
		return "Album - Id: " + id + ", Singer id: " + singer!!.id + ", Title: " + title + ", Release Date: " + releaseDate
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || javaClass != other.javaClass) return false
		if (!super.equals(other)) return false
		val album = other as Album
		return if (title != album.title) false else releaseDate == album.releaseDate
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + if (title != null) title.hashCode() else 0
		result = 31 * result + if (releaseDate != null) releaseDate.hashCode() else 0
		return result
	}

	companion object {
		@Serial
		private val serialVersionUID = 3L
	}
}