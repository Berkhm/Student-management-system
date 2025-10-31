

const BASE_URL = 'http://localhost:8081/rest/api';

document.addEventListener("DOMContentLoaded", () => {
  const page = window.location.pathname.split('/').pop();
  if (page === 'students.html') {
    const openBtn  = document.getElementById('openModal');
    const modal    = document.getElementById('studentModal');
    const closeBtn = document.getElementById('modalClose');
    const overlay  = modal.querySelector('.modal-overlay');
    const form     = document.getElementById('studentForm');

    openBtn.onclick   = () => modal.classList.remove('hidden');
    closeBtn.onclick  = () => modal.classList.add('hidden');
    overlay.onclick   = () => modal.classList.add('hidden');

 
    form.onsubmit = async e => {
      e.preventDefault();
      const data = {
        name:              form['adSoyad'].value,
        mail:              form['mail'].value,
        faculty:           form['faculty'].value,
        telNo:             form['telNo'].value,
        address:           form['address'].value,
        advisorId:         Number(form['advisorId'].value),
        studentNo:         form['studentNo'].value,
        gradeYear:         Number(form['gradeYear'].value),
        gpa:               parseFloat(form['gpa'].value),
        department:        form['department'].value,
        discontinuityDays: Number(form['discontinuityDays'].value)
      };
      try {
        const res = await fetch(`${BASE_URL}/student/save`, {
          method: 'POST',
          headers: {'Content-Type':'application/json'},
          body: JSON.stringify(data)
        });
        if (!res.ok) {
          let err;
          try {
            err = await res.json();
          } catch {
            throw new Error(await res.text());
          }
          throw new Error(err.message || err.error || 'Unknown error');
        }
        modal.classList.add('hidden');
        form.reset();
        loadStudents();
      } catch (err) {
        alert('Öğrenci ekleme hatası: ' + err.message);
      }
    };

    loadStudents();
  }

  if (page === 'teachers.html') {
    const openBtn   = document.getElementById('openTeacherModal');
    const modal     = document.getElementById('teacherModal');
    const closeBtn  = document.getElementById('closeTeacherModal');
    const overlay   = modal.querySelector('.modal-overlay');
    const form      = document.getElementById('teacherForm');

    openBtn.onclick   = () => modal.classList.remove('hidden');
    closeBtn.onclick  = () => modal.classList.add('hidden');
    overlay.onclick   = () => modal.classList.add('hidden');

    form.onsubmit = async e => {
      e.preventDefault();
      const data = {
        name:    form.adSoyad.value,
        mail:    form.mail.value,
        faculty: form.faculty.value,
        telNo:   form.telNo.value,
        address: form.address.value,
        title:   form.title.value,
        major:   form.major.value
      };
      try {
        const res = await fetch(`${BASE_URL}/teacher/save`, {
          method: 'POST',
          headers: {'Content-Type':'application/json'},
          body: JSON.stringify(data)
        });
        if (!res.ok) throw new Error(await res.text());
        modal.classList.add('hidden');
        form.reset();
        loadTeachers();
      } catch (err) {
        alert('Öğretmen ekleme hatası: ' + err.message);
      }
    };

    loadTeachers();
  }

  if (page === 'courses.html') {
    const openBtn  = document.getElementById('openCourseModal');
    const modal    = document.getElementById('courseModal');
    const closeBtn = document.getElementById('closeCourseModal');
    const overlay  = modal.querySelector('.modal-overlay');
    const form     = document.getElementById('courseForm');
    const start    = form.querySelector('#startTime');
    const finish   = form.querySelector('#finishTime');
  
    openBtn.onclick = () => {
      form.reset();
      start.value  = '';    
      finish.value = '';
      modal.classList.remove('hidden');
    };
    closeBtn.onclick  = () => modal.classList.add('hidden');
    overlay.onclick   = () => modal.classList.add('hidden');
  
    form.onsubmit = async e => {
      e.preventDefault();
      const data = {
        subjectType: form.subjectType.value,
        subjectName: form.subjectName.value,
        day:         form.day.value,
        startTime:   form.startTime.value,
        finishTime:  form.finishTime.value,
        classNo:     Number(form.classNo.value),
        credit:      Number(form.credit.value)
      };
      try {
        const res = await fetch(`${BASE_URL}/subject/save`, {
          method: 'POST',
          headers: {'Content-Type':'application/json'},
          body: JSON.stringify(data)
        });
        if (!res.ok) throw new Error(await res.text());
        modal.classList.add('hidden');
        loadCourses();
      } catch (err) {
        alert('Ders ekleme hatası: ' + err.message);
      }
    };
  
    loadCourses();
  }


  if (page === 'grades.html') {
    const studentId = new URLSearchParams(location.search).get('studentId');
    const heading   = document.getElementById('studentNameHeading');
    const openBtn   = document.getElementById('openGradeModal');
    const modal     = document.getElementById('gradeModal');
    const closeBtn  = document.getElementById('closeGradeModal');
    const overlay   = modal.querySelector('.modal-overlay');
    const form      = document.getElementById('gradeForm');
    const subjSelect= form.subjectName;
    const sidInput  = form.studentId;
  
    fetch(`${BASE_URL}/student/findAll`)
      .then(r=>r.json())
      .then(({payload})=>{
        const st = payload.find(s=>String(s.id)===studentId);
        if (st) heading.textContent = `${st.name} Notları`;
      })
      .catch(console.error);
  

    openBtn.onclick = async () => {
      sidInput.value = studentId;
      const res = await fetch(`${BASE_URL}/subject/findAll`);
      const { payload } = await res.json();
      subjSelect.innerHTML = '';
      payload.forEach(c => {
        const opt = document.createElement('option');
        opt.value = c.subjectName;
        opt.textContent = c.subjectName;
        subjSelect.appendChild(opt);
      });
      form.reset();
      sidInput.value = studentId;
      modal.classList.remove('hidden');
    };
    closeBtn.onclick = () => modal.classList.add('hidden');
    overlay.onclick  = () => modal.classList.add('hidden');
  

    form.onsubmit = async e => {
      e.preventDefault();
      const data = {
        studentId:   Number(sidInput.value),
        subjectName: form.subjectName.value,
        midterm:     Number(form.midterm.value),
        finalExam:   Number(form.final.value),      
        average:     parseFloat(form.average.value),
        letterGrade: form.letterGrade.value
      };
      try {
        const res = await fetch(`${BASE_URL}/grade/save`, {
          method: 'POST',
          headers: {'Content-Type':'application/json'},
          body: JSON.stringify(data)
        });
        if (!res.ok) throw new Error(await res.text());
        modal.classList.add('hidden');
        loadGrades(studentId);
      } catch (err) {
        alert('Not ekleme hatası: ' + err.message);
      }
    };
  

    loadGrades(studentId);
  
  }

  if (page === 'detail.html') {
    const studentId = new URLSearchParams(location.search).get('studentId');
    const heading   = document.getElementById('studentNameHeading');
    const tbody     = document.getElementById('detailTableBody');


    fetch(`${BASE_URL}/student/find/${studentId}`)
      .then(res => {
        if (!res.ok) throw new Error('Öğrenci bulunamadı');
        return res.json();
      })
      .then(({ payload: s }) => {
        heading.textContent = `${s.name} – Detaylar`;

        const fields = [
          ['ID',               s.id],
          ['Ad Soyad',         s.name],
          ['Mail',             s.mail],
          ['Fakülte',          s.faculty],
          ['Tel No',           s.telNo],
          ['Adres',            s.address],
          ['Danışman ID',      s.advisorId ?? s.advisorName],
          ['Öğrenci No',       s.studentNo],
          ['Sınıf/Yıl',        s.gradeYear],
          ['GPA',              s.gpa],
          ['Bölüm',            s.department],
          ['Devamsızlık Günleri', s.discontinuityDays]
        ];

        tbody.innerHTML = '';
        fields.forEach(([label, value]) => {
          const tr = document.createElement('tr');
          tr.innerHTML = `<th>${label}</th><td>${value ?? '—'}</td>`;
          tbody.appendChild(tr);
        });
      })
      .catch(err => {
        console.error(err);
        tbody.innerHTML = '<tr><td colspan="2">Öğrenci bilgisi yüklenemedi.</td></tr>';
      });
  }

});

async function loadStudents() {
  try {
    const res  = await fetch(`${BASE_URL}/student/findAll`);
    if (!res.ok) throw new Error('Öğrenciler alınamadı');
    const { payload } = await res.json();
    const list = Array.isArray(payload) ? payload : [];
    const tbody = document.querySelector('tbody');
    tbody.innerHTML = ''; // içini boşaltıoruz eklemeden önce

    list.forEach(s => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.studentNo}</td>
        <td>${s.department}</td>
        <td>${s.advisorName}</td>         <!-- advisorName kullandık -->
        <td>
          <button class="btn-primary"
            onclick="location.href='grades.html?studentId=${s.id}'">Notlar</button>
        </td>
        <td>${s.gpa}</td>
        <td>
          <button class="btn-primary" style="display:block;width:100%;margin-bottom:0.5rem;"
            onclick="updateStudent(${s.id})">Güncelle</button>
          <button class="btn-danger" style="display:block;width:100%;"
            onclick="deleteItem('student', ${s.id}, loadStudents)">Sil</button>
        </td>
        <td>
          <button class="btn-secondary" style="display:block;width:100%;"
            onclick="showDetails(${s.id})">Detay</button>
        </td>`;
      tbody.appendChild(tr);
    });
  } catch (err) {
    alert(err.message);
  }
}

function showDetails(id) {
  location.href = `detail.html?studentId=${id}`;
}

function updateStudent(id) {
  const modalUpd   = document.getElementById('studentUpdateModal');
  const formUpd    = document.getElementById('studentUpdateForm');
  const closeBtn   = document.getElementById('updateModalClose');
  const overlay    = modalUpd.querySelector('.modal-overlay');

  formUpd.reset();
  modalUpd.classList.remove('hidden');


  closeBtn.onclick = () => modalUpd.classList.add('hidden');
  overlay.onclick  = () => modalUpd.classList.add('hidden');

  formUpd.onsubmit = async function(e) {
    e.preventDefault();
    const data = {
      name:              formUpd['adSoyad'].value,
      mail:              formUpd['mail'].value,
      faculty:           formUpd['faculty'].value,
      telNo:             formUpd['telNo'].value,
      address:           formUpd['address'].value,
      advisorId:         Number(formUpd['advisorId'].value),
      studentNo:         formUpd['studentNo'].value,
      gradeYear:         Number(formUpd['gradeYear'].value),
      gpa:               parseFloat(formUpd['gpa'].value),
      department:        formUpd['department'].value,
      discontinuityDays: Number(formUpd['discontinuityDays'].value)
    };
    try {
      const res = await fetch(`${BASE_URL}/student/update/${id}`, {
        method: 'POST',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(data)
      });
      if (!res.ok) throw new Error(await res.text());
      modalUpd.classList.add('hidden');
      formUpd.reset();
      loadStudents();
    } catch (err) {
      alert('Öğrenci güncelleme hatası: ' + err.message);
    }
  };
}


async function deleteItem(entity, id, reloadFn) {
  if (!confirm('Silmek istediğinize emin misiniz?')) return;
  try {
    const res = await fetch(`${BASE_URL}/${entity}/delete/${id}`, { method: 'DELETE' });
    if (!res.ok) throw new Error(await res.text());
    reloadFn();
  } catch (err) {
    alert(err.message);
  }
}


async function loadTeachers() {
  try {
    const res         = await fetch(`${BASE_URL}/teacher/findAll`);
    const { payload } = await res.json();
    const list        = Array.isArray(payload) ? payload : [];
    const tbody       = document.getElementById('teacherTableBody');
    console.log('Fetched teachers:', list);
    tbody.innerHTML   = '';
    list.forEach(t => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${t.id}</td>
        <td>${t.name}</td>
        <td>${t.mail}</td>
        <td>${t.faculty}</td>
        <td>${t.telNo}</td>
        <td>${t.address}</td>
        <td>${t.title}</td>
        <td>${t.major}</td>
              <td>
           <button
            class="btn-primary"
            style="display:block; width:100%; margin-bottom:0.5rem;"
            onclick="updateTeacher(${t.id})">
            Güncelle
          </button>
          <button
            class="btn-danger"
            style="display:block; width:100%;"
            onclick="deleteItem('teacher', ${t.id}, loadTeachers)">
            Sil
          </button>
        </td>`;
      tbody.appendChild(tr);
    });
  } catch (err) {
    console.error(err);
    alert(err.message);
  }
}


async function loadCourses() {
  try {
    const res = await fetch(`${BASE_URL}/subject/findAll`);
    if (!res.ok) throw new Error('Dersler alınamadı');

    const { payload } = await res.json();
    const list = Array.isArray(payload) ? payload : [];

    const tbody = document.getElementById('courseTableBody'); 
    tbody.innerHTML = '';

    list.forEach(c => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${c.id}</td>
        <td>${c.subjectName}</td>
        <td>${c.subjectType}</td>
        <td>${c.day}</td>
        <td>${c.startTime} - ${c.finishTime}</td>
        <td>${c.classNo}</td>
        <td>${c.credit}</td>
        <td>
          <button class="btn-danger"
                  onclick="deleteItem('subject', ${c.id}, loadCourses)">
            Sil
          </button>
        </td>`;
      tbody.appendChild(tr);
    });
  } catch (err) {
    alert(err.message);
  }
}



async function loadGrades(studentId) {
  try {
    const res = await fetch(`${BASE_URL}/grade/findAll/${studentId}`);
    if (!res.ok) throw new Error('Notlar alınamadı');
    const { payload } = await res.json();
    const tbody = document.getElementById('gradeTableBody');
    tbody.innerHTML = '';

    payload.forEach(g => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${g.subjectName}</td>
        <td>${g.midterm}</td>
        <td>${g.finalExam}</td>
        <td>${g.average}</td>
        <td>${g.letterGrade}</td>
        <td>
          <button
            class="btn-primary"
            style="display:block; width:100%; margin-bottom:0.5rem;"
            onclick="updateGrade(${g.id}, '${g.subjectName}', ${studentId})">
            Güncelle
          </button>
          <button
            class="btn-danger"
            style="display:block; width:100%;"
            onclick="deleteItem('grade', ${g.id}, () => loadGrades(${studentId}))">
            Sil
          </button>
        </td>`;
      tbody.appendChild(tr);
    });
  } catch (err) {
    alert(err.message);
  }
}


function updateGrade(gradeId, subjectName, studentId) {

  const modalUpd   = document.getElementById('gradeUpdateModal');
  const formUpd    = document.getElementById('gradeUpdateForm');
  const closeBtn   = document.getElementById('closeGradeUpdateModal');
  const overlay    = modalUpd.querySelector('.modal-overlay');


  formUpd.reset();
  modalUpd.classList.remove('hidden');


  closeBtn.onclick   = () => modalUpd.classList.add('hidden');
  overlay.onclick    = () => modalUpd.classList.add('hidden');


  formUpd.onsubmit = async function(e) {
    e.preventDefault();
    const data = {
      studentId:   studentId,
      subjectName: subjectName,
      midterm:     Number(formUpd.midterm.value),
      finalExam:   Number(formUpd.finalExam.value),
      average:     parseFloat(formUpd.average.value),
      letterGrade: formUpd.letterGrade.value
    };
    try {
      const res = await fetch(`${BASE_URL}/grade/update/${gradeId}`, {
        method: 'POST',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(data)
      });
      if (!res.ok) throw new Error(await res.text());
      modalUpd.classList.add('hidden');
      formUpd.reset();
      loadGrades(studentId);
    } catch (err) {
      alert('Not güncelleme hatası: ' + err.message);
    }
  };
}

function updateTeacher(id) {

  const modal   = document.getElementById('teacherUpdateModal');
  const form    = document.getElementById('teacherUpdateForm');
  const closeBtn= document.getElementById('closeTeacherUpdateModal');
  const overlay = modal.querySelector('.modal-overlay');


  form.reset();
  modal.classList.remove('hidden');


  closeBtn.onclick   = () => modal.classList.add('hidden');
  overlay.onclick    = () => modal.classList.add('hidden');


  form.onsubmit = async function(e) {
    e.preventDefault();

    const data = {
      name:    form.adSoyad.value,
      mail:    form.mail.value,
      faculty: form.faculty.value,
      telNo:   form.telNo.value,
      address: form.address.value,
      title:   form.title.value,
      major:   form.major.value
    };

    try {
      const res = await fetch(`${BASE_URL}/teacher/update/${id}`, {
        method: 'POST',
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify(data)
      });
      if (!res.ok) throw new Error(await res.text());


      modal.classList.add('hidden');
      form.reset();
      loadTeachers();
    } catch (err) {
      alert('Öğretmen güncelleme hatası: ' + err.message);
    }
  };
}




